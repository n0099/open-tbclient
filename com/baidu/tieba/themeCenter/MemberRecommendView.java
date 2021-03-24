package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.a.j;
import d.b.i0.i3.h.e;
/* loaded from: classes5.dex */
public class MemberRecommendView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21567e;

    /* renamed from: f  reason: collision with root package name */
    public View f21568f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f21569g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21570h;
    public TextView i;
    public e j;
    public int k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            TbPageContext tbPageContext;
            int i = 9;
            switch (MemberRecommendView.this.k) {
                case 1:
                    TiebaStatic.log("c10261");
                    i = 8;
                    str = MemberPayStatistic.REFER_PAGE_DRESS_UP_CENTER;
                    break;
                case 2:
                case 3:
                case 9:
                    TiebaStatic.log("c10266");
                    if (MemberRecommendView.this.k == 9) {
                        str = MemberPayStatistic.REFER_PAGE_PERSONALITY_CARDS;
                        break;
                    }
                    str = "";
                    break;
                case 4:
                case 5:
                    TiebaStatic.log("c10278");
                    i = 12;
                    if (MemberRecommendView.this.k != 4) {
                        str = MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND;
                        break;
                    } else {
                        str = MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND;
                        break;
                    }
                case 6:
                case 7:
                    TiebaStatic.log("c10762");
                    i = 19;
                    if (MemberRecommendView.this.k != 7) {
                        str = MemberPayStatistic.REFER_PAGE_POST_BUBBLE;
                        break;
                    } else {
                        str = MemberPayStatistic.REFER_PAGE_ALL_BUBBLE;
                        break;
                    }
                case 8:
                    i = 22;
                    TiebaStatic.log("c11613");
                    str = MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT;
                    break;
                default:
                    i = 0;
                    str = "";
                    break;
            }
            if (MemberRecommendView.this.j == null || (tbPageContext = (TbPageContext) j.a(MemberRecommendView.this.f21567e)) == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i);
            memberPayActivityConfig.setReferPageClickZone(str, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    public MemberRecommendView(Context context) {
        super(context);
        this.f21567e = context;
        f();
    }

    public void d() {
        SkinManager.setBackgroundColor(this.f21568f, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.f21570h, R.color.CAM_X0108);
    }

    public void e(e eVar) {
        if (eVar == null) {
            return;
        }
        this.j = eVar;
        this.f21569g.W(eVar.b(), 10, false);
        this.f21570h.setText(this.j.c());
        if (StringUtils.isNull(this.j.a())) {
            this.i.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        this.i.setText(this.j.a());
    }

    public final void f() {
        View inflate = LayoutInflater.from(this.f21567e).inflate(R.layout.member_extend_view, this);
        this.f21568f = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.vip_icon);
        this.f21569g = tbImageView;
        tbImageView.setDefaultResource(R.drawable.icon_vip_orange);
        this.f21569g.setDefaultBgResource(R.drawable.transparent_bg);
        this.f21569g.setAutoChangeStyle(true);
        this.f21570h = (TextView) this.f21568f.findViewById(R.id.title_view);
        TextView textView = (TextView) this.f21568f.findViewById(R.id.jump_button);
        this.i = textView;
        textView.setOnClickListener(new a());
    }

    public View getButton() {
        return this.i;
    }

    public int getFromType() {
        return this.k;
    }

    public void setFromType(int i) {
        this.k = i;
    }

    public MemberRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21567e = context;
        f();
    }

    public MemberRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f21567e = context;
        f();
    }
}
