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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.o;
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
    private TextView dyo;
    private View.OnClickListener ege;
    private TextView gmQ;
    private LinearLayout jXo;
    private HeadImageView jXp;
    private PbFirstFloorUserLikeButton jXq;
    private at jXr;
    private PbFragment jXs;
    private float jXt;
    private String uid;

    public PbNavbarUserLayout(Context context) {
        super(context);
        this.jXt = 1.0f;
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.jXs != null && PbNavbarUserLayout.this.jXs.cDy() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jXs.cDy().cFu()).dh("fid", PbNavbarUserLayout.this.jXs.cDy().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jXs.cDy().cFu()).dh("fid", PbNavbarUserLayout.this.jXs.cDy().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbNavbarUserLayout.this.getContext(), PbNavbarUserLayout.this.uid, null)));
                }
            }
        };
        init(context);
    }

    public PbNavbarUserLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jXt = 1.0f;
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.jXs != null && PbNavbarUserLayout.this.jXs.cDy() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jXs.cDy().cFu()).dh("fid", PbNavbarUserLayout.this.jXs.cDy().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jXs.cDy().cFu()).dh("fid", PbNavbarUserLayout.this.jXs.cDy().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbNavbarUserLayout.this.getContext(), PbNavbarUserLayout.this.uid, null)));
                }
            }
        };
        init(context);
    }

    public PbNavbarUserLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jXt = 1.0f;
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.jXs != null && PbNavbarUserLayout.this.jXs.cDy() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jXs.cDy().cFu()).dh("fid", PbNavbarUserLayout.this.jXs.cDy().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jXs.cDy().cFu()).dh("fid", PbNavbarUserLayout.this.jXs.cDy().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbNavbarUserLayout.this.getContext(), PbNavbarUserLayout.this.uid, null)));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        setPadding(l.getDimens(context, R.dimen.tbds236), 0, l.getDimens(context, R.dimen.tbds236), 0);
        this.dyo = new TextView(context);
        this.dyo.setText(R.string.pb_navbar_thread_detail);
        this.dyo.setTextSize(0, l.getDimens(context, R.dimen.tbds47));
        this.dyo.setGravity(17);
        addView(this.dyo);
        this.jXo = new LinearLayout(context);
        this.jXo.setOrientation(0);
        this.jXo.setGravity(17);
        addView(this.jXo);
        this.jXp = new HeadImageView(context);
        this.jXp.setId(R.id.pb_title_user_image);
        this.jXp.setIsRound(true);
        this.jXp.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.jXp.setBorderColor(am.getColor(R.color.cp_border_b));
        this.jXp.setOnClickListener(this.ege);
        this.jXp.setPlaceHolder(1);
        this.jXp.setDefaultResource(R.color.cp_bg_line_e);
        this.jXp.setAutoChangeStyle(true);
        this.jXo.addView(this.jXp, new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds58), l.getDimens(context, R.dimen.tbds58)));
        this.gmQ = new TextView(context);
        this.gmQ.setOnClickListener(this.ege);
        this.gmQ.setTextSize(0, l.getDimens(context, R.dimen.tbds34));
        this.gmQ.setSingleLine();
        this.gmQ.setGravity(17);
        this.gmQ.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds14);
        layoutParams.weight = 1.0f;
        this.jXo.addView(this.gmQ, layoutParams);
        this.jXq = new PbFirstFloorUserLikeButton(context);
        this.jXq.kfz = this.ege;
        this.jXq.setId(R.id.pb_title_user_like);
        this.jXq.setTextSize(R.dimen.tbds26);
        this.jXq.getStyleConfig().mf(l.getDimens(getContext(), R.dimen.tbds27));
        this.jXq.getStyleConfig().k(R.drawable.ic_icon_pure_add10_svg, 0, true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds120), l.getDimens(context, R.dimen.tbds58));
        layoutParams2.leftMargin = l.getDimens(context, R.dimen.tbds30);
        this.jXq.setVisibility(8);
        this.jXo.addView(this.jXq, layoutParams2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setPbFragment(PbFragment pbFragment) {
        if (pbFragment != null) {
            this.jXs = pbFragment;
            this.jXp.setPageId(pbFragment.getUniqueId());
        }
    }

    public void setData(e eVar, PostData postData, boolean z) {
        if (eVar != null && eVar.cCi() != null && postData != null && postData.aQx() != null) {
            if (this.jXr == null) {
                bk cCi = eVar.cCi();
                int i = 1;
                if (cCi.aPm()) {
                    i = 4;
                } else if (cCi.aPn()) {
                    i = 6;
                } else if (cCi.aSw()) {
                    i = 7;
                } else if (cCi.aSv()) {
                    i = 5;
                }
                this.jXr = new at(this.jXs.getPageContext(), this.jXq, i);
                this.jXr.l(this.jXs.getUniqueId());
            }
            MetaData aQx = postData.aQx();
            this.jXr.setTid(eVar.getThreadId());
            this.jXr.a(aQx);
            this.jXr.Aw(au.q(eVar));
            this.jXr.setThreadData(eVar.cCi());
            this.uid = aQx.getUserId();
            this.gmQ.setText(aQx.getName_show());
            this.jXp.startLoad(o.wj(aQx.getAvater()), 25, false);
            if (eVar.cCi().aSw() || eVar.cCi().aSv()) {
                this.dyo.setText(R.string.pb_navbar_dynamic);
            } else {
                this.dyo.setText(R.string.pb_navbar_thread_detail);
            }
            a(aQx, z);
        }
    }

    private void a(MetaData metaData, boolean z) {
        if (metaData != null) {
            if (z) {
                this.jXq.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || metaData.hadConcerned()) {
                this.jXq.setVisibility(8);
            } else {
                this.jXq.setVisibility(0);
            }
        }
    }

    public void am(float f) {
        this.jXt = f;
        float f2 = f > 0.4f ? (f - 0.4f) / 0.6f : 0.0f;
        float f3 = f > 0.6f ? 0.0f : 1.0f - (f / 0.6f);
        if (f2 == 0.0f) {
            this.jXo.setVisibility(8);
        } else {
            this.jXo.setVisibility(0);
            this.jXo.setAlpha(f2);
        }
        if (f3 == 0.0f) {
            this.dyo.setVisibility(8);
            return;
        }
        this.dyo.setVisibility(0);
        this.dyo.setAlpha(f3);
    }

    public float getAlphaForScroll() {
        return this.jXt;
    }

    public void onChangeSkinType(int i) {
        if (this.jXq != null) {
            this.jXq.onChangeSkinType(i);
        }
        if (this.gmQ != null) {
            am.setViewTextColor(this.gmQ, (int) R.color.cp_cont_b);
        }
        if (this.dyo != null) {
            am.setViewTextColor(this.dyo, (int) R.color.cp_cont_b);
        }
        if (this.jXp != null) {
            this.jXp.setBorderColor(am.getColor(R.color.cp_border_b));
            this.jXp.invalidate();
        }
    }
}
