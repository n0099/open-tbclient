package com.baidu.tieba.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalScrollView {
    private final Context a;
    private LinearLayout b;
    private int c;
    private int d;
    private int e;
    private int f;
    private HeadImageView g;
    private n h;
    private final View.OnClickListener i;

    public AtSelectFriendList(Context context) {
        super(context);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = 4;
        this.i = new m(this);
        this.a = context;
        a();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = 4;
        this.i = new m(this);
        this.a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(n nVar) {
        this.h = nVar;
    }

    private void a() {
        this.c = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.d = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.e = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.b = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.b.setLayoutParams(layoutParams);
        this.b.setHorizontalScrollBarEnabled(true);
        this.b.setOrientation(0);
        b();
        addView(this.b);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.g == null) {
            this.g = f();
            this.g.setDrawBorder(false);
        }
        this.g.setImageBitmap(com.baidu.tbadk.core.util.h.a(e() ? com.baidu.tieba.u.icon_add_pop_1 : com.baidu.tieba.u.icon_add_pop));
        this.b.addView(this.g);
    }

    private void c() {
        if (d()) {
            this.b.removeView(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int childCount = this.b.getChildCount();
        return childCount > 0 && this.b.getChildAt(childCount + (-1)) == this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        if (getItemLength() < this.f) {
            HeadImageView f = f();
            f.setIsRound(true);
            f.a(bVar.d(), 12, false);
            if (d()) {
                f.setTag(bVar);
                f.setOnClickListener(this.i);
                this.b.addView(f, getItemLength());
                scrollTo(getItemLength() * (this.c + this.e), 0);
                this.b.requestLayout();
            }
            if (getItemLength() >= this.f) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        Object tag;
        int childCount = this.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.g && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) && bVar != null) {
                com.baidu.tbadk.coreExtra.relationship.b bVar2 = (com.baidu.tbadk.coreExtra.relationship.b) tag;
                if (bVar2.b() != null && bVar2.b().equals(bVar.b())) {
                    bVar.setChecked(true);
                    childAt.setTag(bVar);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> getDataList() {
        Object tag;
        String b;
        int childCount = this.b.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.b.getChildAt(i);
            if (childAt != this.g && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.b) && (b = ((com.baidu.tbadk.coreExtra.relationship.b) tag).b()) != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    private boolean e() {
        return TbadkApplication.m252getInst().getSkinType() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        View findViewWithTag = this.b.findViewWithTag(bVar);
        if (findViewWithTag != null) {
            this.b.removeView(findViewWithTag);
            if (!d()) {
                b();
            }
        }
    }

    private HeadImageView f() {
        HeadImageView headImageView = new HeadImageView(this.a);
        headImageView.setIsRound(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.c, this.d);
        layoutParams.setMargins(this.e, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return d() ? this.b.getChildCount() - 1 : this.b.getChildCount();
    }
}
