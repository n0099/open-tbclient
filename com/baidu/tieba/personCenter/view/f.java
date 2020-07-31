package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.g;
/* loaded from: classes16.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.g> {
    private ImageView ilC;
    private View kQw;
    private TextView kQx;
    private LinearLayout kQy;
    private com.baidu.tieba.personCenter.c.g kQz;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.kQw = view.findViewById(R.id.create_center_container);
        this.kQx = (TextView) view.findViewById(R.id.text_create_center);
        this.ilC = (ImageView) view.findViewById(R.id.img_arrow);
        this.ilC.setOnClickListener(this);
        this.kQy = (LinearLayout) view.findViewById(R.id.func_entrance);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.kQx, R.color.cp_cont_b);
        SvgManager.baR().a(this.ilC, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        for (int i2 = 0; i2 < this.kQy.getChildCount(); i2++) {
            ao.setViewTextColor((TextView) this.kQy.getChildAt(i2).findViewById(R.id.create_center_item_text), R.color.cp_cont_b);
        }
        com.baidu.tbadk.core.util.e.a.bbq().mj(1).ml(l.getDimens(this.mContext, R.dimen.tbds21)).mq(R.color.cp_bg_line_d).mm(R.color.cp_shadow_a_alpha33).mk(4369).mn(l.getDimens(this.mContext, R.dimen.tbds16)).mo(0).mp(l.getDimens(this.mContext, R.dimen.tbds5)).aX(this.kQw);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_create_center;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personCenter.c.g gVar) {
        if (gVar != null && !x.isEmpty(gVar.dAT)) {
            if (gVar != this.kQz) {
                this.kQy.removeAllViews();
                int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.tbds44) * 2)) / gVar.dAT.size();
                for (g.a aVar : gVar.dAT) {
                    if (aVar != null) {
                        this.kQy.addView(a(this.mContext, aVar), new LinearLayout.LayoutParams(equipmentWidth, -2));
                    }
                }
                this.kQz = gVar;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.ilC.getId()) {
            bx(R.string.create_center, TbConfig.URL_CREATE_CENTER);
            TiebaStatic.log("c13842");
        }
    }

    private View a(Context context, final g.a aVar) {
        if (aVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setId(R.id.create_center_item_img);
        tbImageView.setImageResource(aVar.kPp);
        int dimens = l.getDimens(context, R.dimen.tbds126);
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(dimens, dimens));
        TextView textView = new TextView(context);
        textView.setId(R.id.create_center_item_text);
        textView.setText(aVar.text);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize32));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(context, R.dimen.tbds32);
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.a(aVar);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g.a aVar) {
        if (aVar != null && this.kQz != null && this.kQz.mUserData != null) {
            if (aVar.type == 1) {
                TiebaStatic.log(new ap("c12523").ah("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.kQz.mUserData.getUserId(), this.kQz.mUserData.getSex(), this.kQz.mUserData.getPortrait())));
                TiebaStatic.log("c13843");
            } else if (aVar.type == 2) {
                bx(R.string.god_authentication, TbConfig.URL_GOD_AUTH);
                TiebaStatic.log(new ap("c13844").ah("obj_type", 1));
            } else if (aVar.type == 5) {
                bx(R.string.god_examination, TbConfig.URL_GOD_EXAMINE);
                TiebaStatic.log(new ap("c13844").ah("obj_type", 2));
            } else if (aVar.type == 3) {
                bx(R.string.create_college, TbConfig.URL_CREATE_COLLEGE);
                TiebaStatic.log("c13845");
            } else if (aVar.type == 4) {
                bx(R.string.hot_activities, TbConfig.URL_HOT_ACTIVITIES);
                TiebaStatic.log("c13846");
            }
        }
    }

    private void bx(int i, String str) {
        this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(i), str, true)));
    }
}
