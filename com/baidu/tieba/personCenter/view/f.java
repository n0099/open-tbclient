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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.g;
/* loaded from: classes21.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.g> {
    private ImageView iHi;
    private View lpq;
    private TextView lpr;
    private LinearLayout lps;
    private com.baidu.tieba.personCenter.c.g lpt;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.lpq = view.findViewById(R.id.create_center_container);
        this.lpr = (TextView) view.findViewById(R.id.text_create_center);
        this.iHi = (ImageView) view.findViewById(R.id.img_arrow);
        this.iHi.setOnClickListener(this);
        this.lps = (LinearLayout) view.findViewById(R.id.func_entrance);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.lpr, R.color.cp_cont_b);
        SvgManager.bkl().a(this.iHi, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        for (int i2 = 0; i2 < this.lps.getChildCount(); i2++) {
            ap.setViewTextColor((TextView) this.lps.getChildAt(i2).findViewById(R.id.create_center_item_text), R.color.cp_cont_b);
        }
        com.baidu.tbadk.core.util.e.a.bkK().oz(1).oB(l.getDimens(this.mContext, R.dimen.tbds21)).oG(R.color.cp_bg_line_d).oC(R.color.cp_shadow_a_alpha33).oA(4369).oD(l.getDimens(this.mContext, R.dimen.tbds16)).oE(0).oF(l.getDimens(this.mContext, R.dimen.tbds5)).bb(this.lpq);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_create_center;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personCenter.c.g gVar) {
        if (gVar != null && !y.isEmpty(gVar.dMl)) {
            if (gVar != this.lpt) {
                this.lps.removeAllViews();
                int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.tbds44) * 2)) / gVar.dMl.size();
                for (g.a aVar : gVar.dMl) {
                    if (aVar != null) {
                        this.lps.addView(a(this.mContext, aVar), new LinearLayout.LayoutParams(equipmentWidth, -2));
                    }
                }
                this.lpt = gVar;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.iHi.getId()) {
            by(R.string.create_center, TbConfig.URL_CREATE_CENTER);
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
        tbImageView.setImageResource(aVar.loi);
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
        if (aVar != null && this.lpt != null && this.lpt.mUserData != null) {
            if (aVar.type == 1) {
                TiebaStatic.log(new aq("c12523").ai("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.lpt.mUserData.getUserId(), this.lpt.mUserData.getSex(), this.lpt.mUserData.getPortrait())));
                TiebaStatic.log("c13843");
            } else if (aVar.type == 2) {
                by(R.string.god_authentication, TbConfig.URL_GOD_AUTH);
                TiebaStatic.log(new aq("c13844").ai("obj_type", 1));
            } else if (aVar.type == 5) {
                by(R.string.god_examination, TbConfig.URL_GOD_EXAMINE);
                TiebaStatic.log(new aq("c13844").ai("obj_type", 2));
            } else if (aVar.type == 3) {
                by(R.string.create_college, TbConfig.URL_CREATE_COLLEGE);
                TiebaStatic.log("c13845");
            } else if (aVar.type == 4) {
                by(R.string.hot_activities, TbConfig.URL_HOT_ACTIVITIES);
                TiebaStatic.log("c13846");
            }
        }
    }

    private void by(int i, String str) {
        this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(i), str, true)));
    }
}
