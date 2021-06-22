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
import d.a.n0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FeedBackTopListView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22163e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a2> f22164f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f22165g;

    /* renamed from: h  reason: collision with root package name */
    public int f22166h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22167e;

        public a(String str) {
            this.f22167e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(FeedBackTopListView.this.f22163e).createNormalCfg(this.f22167e, null, WriteActivityConfig.FEED_BACK)));
        }
    }

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public final View b(a2 a2Var, int i2) {
        if (a2Var == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.f22163e).inflate(R.layout.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(R.id.frs_top_title);
        inflate.findViewById(R.id.frs_top_divider);
        String z1 = a2Var.z1();
        textView.setText(a2Var.A1());
        this.f22165g.getLayoutMode().k(this.f22166h == 1);
        this.f22165g.getLayoutMode().j(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_notice);
        SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new a(z1));
        return inflate;
    }

    public void c(ArrayList<a2> arrayList, TbPageContext<?> tbPageContext) {
        this.f22165g = tbPageContext;
        if (arrayList != null && arrayList.size() != 0) {
            setVisibility(0);
            if (arrayList.size() > 3) {
                this.f22164f = new ArrayList<>(arrayList.subList(0, 3));
            } else {
                this.f22164f = arrayList;
            }
            for (int i2 = 0; i2 < this.f22164f.size(); i2++) {
                addView(b(this.f22164f.get(i2), i2));
            }
            return;
        }
        setVisibility(8);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22163e = null;
        this.f22164f = null;
        this.f22166h = 3;
        this.f22163e = context;
        this.f22166h = TbadkCoreApplication.getInst().getSkinType();
    }
}
