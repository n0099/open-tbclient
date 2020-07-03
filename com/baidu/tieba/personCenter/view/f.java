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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.g;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.g> {
    private ImageView ifB;
    private View kHw;
    private TextView kHx;
    private LinearLayout kHy;
    private com.baidu.tieba.personCenter.c.g kHz;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.kHw = view.findViewById(R.id.create_center_container);
        this.kHx = (TextView) view.findViewById(R.id.text_create_center);
        this.ifB = (ImageView) view.findViewById(R.id.img_arrow);
        this.ifB.setOnClickListener(this);
        this.kHy = (LinearLayout) view.findViewById(R.id.func_entrance);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setViewTextColor(this.kHx, (int) R.color.cp_cont_b);
        SvgManager.aWQ().a(this.ifB, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        for (int i2 = 0; i2 < this.kHy.getChildCount(); i2++) {
            an.setViewTextColor((TextView) this.kHy.getChildAt(i2).findViewById(R.id.create_center_item_text), (int) R.color.cp_cont_b);
        }
        com.baidu.tbadk.core.util.e.a.aXp().lP(1).lR(l.getDimens(this.mContext, R.dimen.tbds21)).lW(R.color.cp_bg_line_d).lS(R.color.cp_shadow_a_alpha33).lQ(4369).lT(l.getDimens(this.mContext, R.dimen.tbds16)).lU(0).lV(l.getDimens(this.mContext, R.dimen.tbds5)).aR(this.kHw);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_create_center;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personCenter.c.g gVar) {
        if (gVar != null && !w.isEmpty(gVar.dvd)) {
            if (gVar != this.kHz) {
                this.kHy.removeAllViews();
                int equipmentWidth = (l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.tbds44) * 2)) / gVar.dvd.size();
                for (g.a aVar : gVar.dvd) {
                    if (aVar != null) {
                        this.kHy.addView(a(this.mContext, aVar), new LinearLayout.LayoutParams(equipmentWidth, -2));
                    }
                }
                this.kHz = gVar;
            }
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.ifB.getId()) {
            bw(R.string.create_center, TbConfig.URL_CREATE_CENTER);
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
        tbImageView.setImageResource(aVar.kGo);
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
        if (aVar != null && this.kHz != null && this.kHz.mUserData != null) {
            if (aVar.type == 1) {
                TiebaStatic.log(new ao("c12523").ag("obj_locate", 8));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mTbPageContext.getPageActivity(), this.kHz.mUserData.getUserId(), this.kHz.mUserData.getSex(), this.kHz.mUserData.getPortrait())));
            } else if (aVar.type == 2) {
                bw(R.string.god_authentication, TbConfig.URL_GOD_AUTH);
            } else if (aVar.type == 5) {
                bw(R.string.god_authentication, TbConfig.URL_GOD_EXAMINE);
            } else if (aVar.type == 3) {
                bw(R.string.create_college, TbConfig.URL_CREATE_COLLEGE);
            } else if (aVar.type == 4) {
                bw(R.string.hot_activities, TbConfig.URL_HOT_ACTIVITIES);
            }
        }
    }

    private void bw(int i, String str) {
        this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(i), str, true)));
    }
}
