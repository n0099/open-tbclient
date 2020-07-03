package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class PbNavbarUserLayout extends FrameLayout {
    private TextView dDu;
    private View.OnClickListener eoP;
    private TextView gzP;
    private LinearLayout ksm;
    private HeadImageView ksn;
    private PbFirstFloorUserLikeButton kso;
    private at ksp;
    private PbFragment ksq;
    private float ksr;
    private String uid;

    public PbNavbarUserLayout(Context context) {
        super(context);
        this.ksr = 1.0f;
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.ksq != null && PbNavbarUserLayout.this.ksq.cIe() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new ao("c13697").dk("tid", PbNavbarUserLayout.this.ksq.cIe().cKa()).dk("fid", PbNavbarUserLayout.this.ksq.cIe().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new ao("c13697").dk("tid", PbNavbarUserLayout.this.ksq.cIe().cKa()).dk("fid", PbNavbarUserLayout.this.ksq.cIe().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbNavbarUserLayout.this.getContext(), PbNavbarUserLayout.this.uid, null)));
                }
            }
        };
        init(context);
    }

    public PbNavbarUserLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ksr = 1.0f;
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.ksq != null && PbNavbarUserLayout.this.ksq.cIe() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new ao("c13697").dk("tid", PbNavbarUserLayout.this.ksq.cIe().cKa()).dk("fid", PbNavbarUserLayout.this.ksq.cIe().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new ao("c13697").dk("tid", PbNavbarUserLayout.this.ksq.cIe().cKa()).dk("fid", PbNavbarUserLayout.this.ksq.cIe().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbNavbarUserLayout.this.getContext(), PbNavbarUserLayout.this.uid, null)));
                }
            }
        };
        init(context);
    }

    public PbNavbarUserLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ksr = 1.0f;
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.ksq != null && PbNavbarUserLayout.this.ksq.cIe() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new ao("c13697").dk("tid", PbNavbarUserLayout.this.ksq.cIe().cKa()).dk("fid", PbNavbarUserLayout.this.ksq.cIe().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new ao("c13697").dk("tid", PbNavbarUserLayout.this.ksq.cIe().cKa()).dk("fid", PbNavbarUserLayout.this.ksq.cIe().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbNavbarUserLayout.this.getContext(), PbNavbarUserLayout.this.uid, null)));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        setPadding(l.getDimens(context, R.dimen.tbds236), 0, l.getDimens(context, R.dimen.tbds236), 0);
        this.dDu = new TextView(context);
        this.dDu.setText(R.string.pb_navbar_thread_detail);
        this.dDu.setTextSize(0, l.getDimens(context, R.dimen.tbds47));
        this.dDu.setGravity(17);
        addView(this.dDu);
        this.ksm = new LinearLayout(context);
        this.ksm.setOrientation(0);
        this.ksm.setGravity(17);
        addView(this.ksm);
        this.ksn = new HeadImageView(context);
        this.ksn.setId(R.id.pb_title_user_image);
        this.ksn.setIsRound(true);
        this.ksn.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.ksn.setBorderColor(an.getColor(R.color.cp_border_b));
        this.ksn.setOnClickListener(this.eoP);
        this.ksn.setPlaceHolder(1);
        this.ksn.setDefaultResource(R.color.cp_bg_line_e);
        this.ksn.setAutoChangeStyle(true);
        this.ksm.addView(this.ksn, new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds58), l.getDimens(context, R.dimen.tbds58)));
        this.gzP = new TextView(context);
        this.gzP.setOnClickListener(this.eoP);
        this.gzP.setTextSize(0, l.getDimens(context, R.dimen.tbds34));
        this.gzP.setSingleLine();
        this.gzP.setGravity(17);
        this.gzP.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds14);
        layoutParams.weight = 1.0f;
        this.ksm.addView(this.gzP, layoutParams);
        this.kso = new PbFirstFloorUserLikeButton(context);
        this.kso.kAs = this.eoP;
        this.kso.setId(R.id.pb_title_user_like);
        this.kso.setTextSize(R.dimen.tbds26);
        this.kso.getStyleConfig().my(l.getDimens(getContext(), R.dimen.tbds27));
        this.kso.getStyleConfig().k(R.drawable.ic_icon_pure_add10_svg, 0, true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds120), l.getDimens(context, R.dimen.tbds58));
        layoutParams2.leftMargin = l.getDimens(context, R.dimen.tbds30);
        this.kso.setVisibility(8);
        this.ksm.addView(this.kso, layoutParams2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setPbFragment(PbFragment pbFragment) {
        if (pbFragment != null) {
            this.ksq = pbFragment;
            this.ksn.setPageId(pbFragment.getUniqueId());
        }
    }

    public void setData(e eVar, PostData postData, boolean z) {
        if (eVar != null && eVar.cGN() != null && postData != null && postData.aSp() != null) {
            if (this.ksp == null) {
                bu cGN = eVar.cGN();
                int i = 1;
                if (cGN.aQX()) {
                    i = 4;
                } else if (cGN.aQY()) {
                    i = 6;
                } else if (cGN.aUm()) {
                    i = 7;
                } else if (cGN.aUl()) {
                    i = 5;
                }
                this.ksp = new at(this.ksq.getPageContext(), this.kso, i);
                this.ksp.l(this.ksq.getUniqueId());
            }
            MetaData aSp = postData.aSp();
            this.ksp.setTid(eVar.getThreadId());
            this.ksp.a(aSp);
            this.ksp.BA(au.r(eVar));
            this.ksp.setThreadData(eVar.cGN());
            this.uid = aSp.getUserId();
            this.gzP.setText(aSp.getName_show());
            this.ksn.startLoad(p.wz(aSp.getAvater()), 25, false);
            if (eVar.cGN().aUm() || eVar.cGN().aUl()) {
                this.dDu.setText(R.string.pb_navbar_dynamic);
            } else {
                this.dDu.setText(R.string.pb_navbar_thread_detail);
            }
            a(aSp, z);
        }
    }

    private void a(MetaData metaData, boolean z) {
        if (metaData != null) {
            if (z) {
                this.kso.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || metaData.hadConcerned()) {
                this.kso.setVisibility(8);
            } else {
                this.kso.setVisibility(0);
            }
        }
    }

    public void ar(float f) {
        this.ksr = f;
        float f2 = f > 0.4f ? (f - 0.4f) / 0.6f : 0.0f;
        float f3 = f > 0.6f ? 0.0f : 1.0f - (f / 0.6f);
        if (f2 == 0.0f) {
            this.ksm.setVisibility(8);
        } else {
            this.ksm.setVisibility(0);
            this.ksm.setAlpha(f2);
        }
        if (f3 == 0.0f) {
            this.dDu.setVisibility(8);
            return;
        }
        this.dDu.setVisibility(0);
        this.dDu.setAlpha(f3);
    }

    public float getAlphaForScroll() {
        return this.ksr;
    }

    public void onChangeSkinType(int i) {
        if (this.kso != null) {
            this.kso.onChangeSkinType(i);
        }
        if (this.gzP != null) {
            an.setViewTextColor(this.gzP, (int) R.color.cp_cont_b);
        }
        if (this.dDu != null) {
            an.setViewTextColor(this.dDu, (int) R.color.cp_cont_b);
        }
        if (this.ksn != null) {
            this.ksn.setBorderColor(an.getColor(R.color.cp_border_b));
            this.ksn.invalidate();
        }
    }
}
