package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.c.e.m.b;
import d.a.n0.r.q.b1;
/* loaded from: classes5.dex */
public class PbGiftListView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f19702e;

    /* renamed from: f  reason: collision with root package name */
    public View f19703f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19704g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f19705h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f19706i;
    public TbImageView j;
    public TextView k;
    public TextView l;
    public String m;
    public String n;
    public long o;
    public long p;
    public long q;
    public int r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext tbPageContext = (TbPageContext) j.a(PbGiftListView.this.f19702e);
            if (tbPageContext == null) {
                return;
            }
            if (TbadkCoreApplication.isLogin()) {
                if (StringUtils.isNull(PbGiftListView.this.m)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.o, PbGiftListView.this.m, PbGiftListView.this.n, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.p, PbGiftListView.this.q)));
                return;
            }
            ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity());
        }
    }

    public PbGiftListView(Context context) {
        super(context);
        this.r = 3;
    }

    public void g(b1 b1Var, String str, String str2, long j, long j2, long j3) {
        this.o = j;
        this.m = str;
        this.n = str2;
        this.q = j3;
        this.p = j2;
        if (b1Var != null && b1Var.a() != null && b1Var.a().size() > 0) {
            int size = b1Var.a().size() > 4 ? 4 : b1Var.a().size();
            if (size == 1) {
                this.f19704g.U(b1Var.a().get(0).f53731a, 10, false);
                this.f19704g.setVisibility(0);
                this.f19705h.setVisibility(8);
                this.f19706i.setVisibility(8);
                this.j.setVisibility(8);
            } else if (size == 2) {
                this.f19704g.U(b1Var.a().get(0).f53731a, 10, false);
                this.f19705h.U(b1Var.a().get(1).f53731a, 10, false);
                this.f19704g.setVisibility(0);
                this.f19705h.setVisibility(0);
                this.f19706i.setVisibility(8);
                this.j.setVisibility(8);
            } else if (size == 3) {
                this.f19704g.U(b1Var.a().get(0).f53731a, 10, false);
                this.f19705h.U(b1Var.a().get(1).f53731a, 10, false);
                this.f19706i.U(b1Var.a().get(2).f53731a, 10, false);
                this.f19704g.setVisibility(0);
                this.f19705h.setVisibility(0);
                this.f19706i.setVisibility(0);
                this.j.setVisibility(8);
            } else if (size == 4) {
                this.f19704g.U(b1Var.a().get(0).f53731a, 10, false);
                this.f19705h.U(b1Var.a().get(1).f53731a, 10, false);
                this.f19706i.U(b1Var.a().get(2).f53731a, 10, false);
                this.j.U(b1Var.a().get(3).f53731a, 10, false);
                this.f19704g.setVisibility(0);
                this.f19705h.setVisibility(0);
                this.f19706i.setVisibility(0);
                this.j.setVisibility(0);
            }
            if (b1Var.b() > 0) {
                this.k.setText(String.format(this.f19702e.getResources().getString(R.string.gift_counts), Integer.valueOf(b1Var.b())));
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (j == b.f(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                this.l.setVisibility(8);
                return;
            } else {
                this.l.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    public long getPostId() {
        return this.q;
    }

    public long getThreadId() {
        return this.p;
    }

    public final void h() {
        View inflate = View.inflate(this.f19702e, R.layout.pb_gift_list_item, this);
        this.f19703f = inflate;
        this.f19704g = (TbImageView) inflate.findViewById(R.id.pb_gift_view1);
        this.f19705h = (TbImageView) this.f19703f.findViewById(R.id.pb_gift_view2);
        this.f19706i = (TbImageView) this.f19703f.findViewById(R.id.pb_gift_view3);
        this.j = (TbImageView) this.f19703f.findViewById(R.id.pb_gift_view4);
        this.f19704g.setDefaultBgResource(R.drawable.transparent_bg);
        this.f19705h.setDefaultBgResource(R.drawable.transparent_bg);
        this.f19706i.setDefaultBgResource(R.drawable.transparent_bg);
        this.j.setDefaultBgResource(R.drawable.transparent_bg);
        this.f19704g.setDefaultResource(R.drawable.icon_gift_moren);
        this.f19705h.setDefaultResource(R.drawable.icon_gift_moren);
        this.f19706i.setDefaultResource(R.drawable.icon_gift_moren);
        this.j.setDefaultResource(R.drawable.icon_gift_moren);
        this.k = (TextView) this.f19703f.findViewById(R.id.pb_gift_number_view);
        TextView textView = (TextView) this.f19703f.findViewById(R.id.pb_gift_send_view);
        this.l = textView;
        textView.setOnClickListener(new a());
    }

    public void i() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.r != skinType) {
            this.r = skinType;
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0304, 1);
        }
    }

    public void setPostId(long j) {
        this.q = j;
    }

    public void setThreadId(long j) {
        this.p = j;
    }

    public PbGiftListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = 3;
        this.f19702e = context;
        h();
    }

    public PbGiftListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = 3;
        this.f19702e = context;
        h();
    }
}
