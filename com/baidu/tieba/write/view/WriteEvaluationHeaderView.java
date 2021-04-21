package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {

    /* renamed from: e  reason: collision with root package name */
    public int f22080e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f22081f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f22082g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22083h;
    public View i;
    public View j;
    public ItemCardView k;
    public RankStarView l;
    public c m;
    public b n;
    public TbRichTextEvaluateItemInfo o;
    public boolean p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteEvaluationHeaderView.this.b();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(float f2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onClose();
    }

    public WriteEvaluationHeaderView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void a(float f2) {
        b bVar = this.n;
        if (bVar != null) {
            bVar.a(f2);
        }
    }

    public void b() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RelevanceItemSearchActivityConfig(getContext(), 25048)));
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.f22082g = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.f22081f = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.i = findViewById(R.id.write_select_item_relevance);
        this.f22083h = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.j = findViewById(R.id.item_relevance_line);
        this.k = (ItemCardView) findViewById(R.id.item_star_info);
        RankStarView rankStarView = (RankStarView) findViewById(R.id.item_set_new_star);
        this.l = rankStarView;
        rankStarView.setStarSpacing(l.g(getContext(), R.dimen.tbds30));
        this.l.setClickable(true);
        this.l.setStarChangListener(this);
        this.k.c();
        this.k.setOnCloseListener(this);
        this.k.setSizeStyle(1);
        d();
    }

    public final void d() {
        this.i.setOnClickListener(new a());
    }

    public boolean e() {
        return this.l.c();
    }

    public void f() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f22080e) {
            return;
        }
        this.f22080e = skinType;
        EMTextView eMTextView = this.f22081f;
        if (eMTextView != null) {
            SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0109);
            d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.f22081f);
            d2.k(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
        }
        if (this.f22083h != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22083h, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
        View view = this.j;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0210);
        }
        ItemCardView itemCardView = this.k;
        if (itemCardView != null) {
            SkinManager.setBackgroundColor(itemCardView, R.color.CAM_X0206);
        }
        EMTextView eMTextView2 = this.f22082g;
        if (eMTextView2 != null) {
            SkinManager.setViewTextColor(eMTextView2, R.color.CAM_X0105);
        }
        RankStarView rankStarView = this.l;
        if (rankStarView != null) {
            rankStarView.e(skinType);
        }
        RankStarView rankStarView2 = this.l;
        if (rankStarView2 != null) {
            rankStarView2.e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.o;
    }

    public ItemCardView getItemStarInfo() {
        return this.k;
    }

    public int getStarCount() {
        return this.l.getStarCount();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.k.setVisibility(8);
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.f22081f.setVisibility(0);
        c cVar = this.m;
        if (cVar != null) {
            cVar.onClose();
        }
    }

    public void setItemCloseListener(c cVar) {
        this.m = cVar;
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.o = tbRichTextEvaluateItemInfo;
        if (this.p) {
            this.k.setVisibility(0);
            this.j.setVisibility(8);
        }
        this.l.setVisibility(0);
        this.l.setStarCount(0.0f);
        this.f22081f.setVisibility(8);
        this.k.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public void setShowItemInfo(boolean z) {
        this.p = z;
        this.k.setVisibility(8);
        this.j.setVisibility(0);
        this.i.setVisibility(8);
    }

    public void setStarChangeListener(b bVar) {
        this.n = bVar;
    }

    public void setStarCount(int i) {
        this.l.setStarCount(i);
    }

    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22080e = 3;
        this.p = true;
        c();
    }
}
