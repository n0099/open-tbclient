package com.baidu.tieba.write.write;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FeedBackTopListView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22050e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a2> f22051f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f22052g;

    /* renamed from: h  reason: collision with root package name */
    public int f22053h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22054e;

        public a(String str) {
            this.f22054e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(FeedBackTopListView.this.f22050e).createNormalCfg(this.f22054e, null, WriteActivityConfig.FEED_BACK)));
        }
    }

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public final View b(a2 a2Var, int i2) {
        if (a2Var == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.f22050e).inflate(R.layout.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(R.id.frs_top_title);
        inflate.findViewById(R.id.frs_top_divider);
        String x1 = a2Var.x1();
        textView.setText(a2Var.y1());
        this.f22052g.getLayoutMode().k(this.f22053h == 1);
        this.f22052g.getLayoutMode().j(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_notice);
        SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new a(x1));
        return inflate;
    }

    public void c(ArrayList<a2> arrayList, TbPageContext<?> tbPageContext) {
        this.f22052g = tbPageContext;
        if (arrayList != null && arrayList.size() != 0) {
            setVisibility(0);
            if (arrayList.size() > 3) {
                this.f22051f = new ArrayList<>(arrayList.subList(0, 3));
            } else {
                this.f22051f = arrayList;
            }
            for (int i2 = 0; i2 < this.f22051f.size(); i2++) {
                addView(b(this.f22051f.get(i2), i2));
            }
            return;
        }
        setVisibility(8);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22050e = null;
        this.f22051f = null;
        this.f22053h = 3;
        this.f22050e = context;
        this.f22053h = TbadkCoreApplication.getInst().getSkinType();
    }
}
