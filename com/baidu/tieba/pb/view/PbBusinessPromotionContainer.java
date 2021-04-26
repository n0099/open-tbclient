package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.w1;
/* loaded from: classes3.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    public static final int q = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    public static final int r = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f20318e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f20319f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20320g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20321h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f20322i;
    public View.OnClickListener j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final View.OnClickListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            view.setTag(PbBusinessPromotionContainer.this.f20322i);
            if (PbBusinessPromotionContainer.this.j != null) {
                PbBusinessPromotionContainer.this.j.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            if (PbBusinessPromotionContainer.this.f20322i != null && PbBusinessPromotionContainer.this.f20322i.c0() == longValue && PbBusinessPromotionContainer.this.m) {
                PbBusinessPromotionContainer.this.l = false;
                PbBusinessPromotionContainer.this.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            if (PbBusinessPromotionContainer.this.f20322i != null && PbBusinessPromotionContainer.this.f20322i.c0() == longValue && PbBusinessPromotionContainer.this.m) {
                PbBusinessPromotionContainer.this.l = true;
                PbBusinessPromotionContainer.this.j();
            }
        }
    }

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public void f(a2 a2Var, w1 w1Var, boolean z) {
        if (a2Var != null && w1Var != null && !StringUtils.isNull(w1Var.g())) {
            this.f20322i = a2Var;
            i(z);
            this.m = true;
            setVisibility(0);
            this.f20319f.V(w1Var.a(), 10, false);
            this.f20320g.setText(w1Var.g());
            if (this.k) {
                return;
            }
            this.k = true;
            this.l = w1Var.getIsLike();
            j();
            return;
        }
        this.m = false;
        setVisibility(8);
    }

    public void g() {
        this.k = false;
        this.l = false;
        this.m = false;
        if (this.p != null) {
            MessageManager.getInstance().unRegisterListener(this.p);
        }
        if (this.o != null) {
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void h() {
        SkinManager.setViewTextColor(this.f20320g, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.f20318e, R.drawable.pb_business_promotion_bg);
        if (this.l) {
            SkinManager.setViewTextColor(this.f20321h, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f20321h, 17170445);
            return;
        }
        SkinManager.setViewTextColor(this.f20321h, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f20321h, R.drawable.pb_business_promotion_attention_bg);
    }

    public final void i(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, q, 0, r);
        }
    }

    public final void j() {
        if (this.l) {
            this.f20321h.setText(getResources().getString(R.string.followed));
            SkinManager.setViewTextColor(this.f20321h, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f20321h, 17170445);
            this.f20321h.setOnClickListener(null);
            return;
        }
        this.f20321h.setText(getResources().getString(R.string.attention));
        SkinManager.setViewTextColor(this.f20321h, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f20321h, R.drawable.pb_business_promotion_attention_bg);
        this.f20321h.setOnClickListener(this.n);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = new a();
        this.o = new b(2001336);
        this.p = new c(2001335);
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.f20318e = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.f20319f = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.f20320g = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.f20321h = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.f20319f.setRadius(l.g(context, R.dimen.tbds24));
        this.f20319f.setConrers(5);
        this.f20319f.setDefaultResource(17170445);
        this.f20319f.setDefaultBgResource(17170445);
        this.f20318e.setOnClickListener(this.n);
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.o);
    }
}
