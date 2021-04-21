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
import d.b.i0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FeedBackTopListView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f22118e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a2> f22119f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f22120g;

    /* renamed from: h  reason: collision with root package name */
    public int f22121h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f22122e;

        public a(String str) {
            this.f22122e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(FeedBackTopListView.this.f22118e).createNormalCfg(this.f22122e, null, WriteActivityConfig.FEED_BACK)));
        }
    }

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public final View b(a2 a2Var, int i) {
        if (a2Var == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.f22118e).inflate(R.layout.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(R.id.frs_top_title);
        inflate.findViewById(R.id.frs_top_divider);
        String w1 = a2Var.w1();
        textView.setText(a2Var.x1());
        this.f22120g.getLayoutMode().k(this.f22121h == 1);
        this.f22120g.getLayoutMode().j(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_notice);
        SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new a(w1));
        return inflate;
    }

    public void c(ArrayList<a2> arrayList, TbPageContext<?> tbPageContext) {
        this.f22120g = tbPageContext;
        if (arrayList != null && arrayList.size() != 0) {
            setVisibility(0);
            if (arrayList.size() > 3) {
                this.f22119f = new ArrayList<>(arrayList.subList(0, 3));
            } else {
                this.f22119f = arrayList;
            }
            for (int i = 0; i < this.f22119f.size(); i++) {
                addView(b(this.f22119f.get(i), i));
            }
            return;
        }
        setVisibility(8);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22118e = null;
        this.f22119f = null;
        this.f22121h = 3;
        this.f22118e = context;
        this.f22121h = TbadkCoreApplication.getInst().getSkinType();
    }
}
