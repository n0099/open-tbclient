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
    private TextView gnb;
    private LinearLayout jYu;
    private HeadImageView jYv;
    private PbFirstFloorUserLikeButton jYw;
    private at jYx;
    private PbFragment jYy;
    private float jYz;
    private String uid;

    public PbNavbarUserLayout(Context context) {
        super(context);
        this.jYz = 1.0f;
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.jYy != null && PbNavbarUserLayout.this.jYy.cDO() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jYy.cDO().cFK()).dh("fid", PbNavbarUserLayout.this.jYy.cDO().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jYy.cDO().cFK()).dh("fid", PbNavbarUserLayout.this.jYy.cDO().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbNavbarUserLayout.this.getContext(), PbNavbarUserLayout.this.uid, null)));
                }
            }
        };
        init(context);
    }

    public PbNavbarUserLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jYz = 1.0f;
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.jYy != null && PbNavbarUserLayout.this.jYy.cDO() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jYy.cDO().cFK()).dh("fid", PbNavbarUserLayout.this.jYy.cDO().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jYy.cDO().cFK()).dh("fid", PbNavbarUserLayout.this.jYy.cDO().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PbNavbarUserLayout.this.getContext(), PbNavbarUserLayout.this.uid, null)));
                }
            }
        };
        init(context);
    }

    public PbNavbarUserLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jYz = 1.0f;
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbNavbarUserLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null && PbNavbarUserLayout.this.jYy != null && PbNavbarUserLayout.this.jYy.cDO() != null) {
                    if (view != null && view.getId() == R.id.pb_title_user_like) {
                        TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jYy.cDO().cFK()).dh("fid", PbNavbarUserLayout.this.jYy.cDO().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 2));
                        return;
                    }
                    TiebaStatic.log(new an("c13697").dh("tid", PbNavbarUserLayout.this.jYy.cDO().cFK()).dh("fid", PbNavbarUserLayout.this.jYy.cDO().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_type", 1));
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
        this.jYu = new LinearLayout(context);
        this.jYu.setOrientation(0);
        this.jYu.setGravity(17);
        addView(this.jYu);
        this.jYv = new HeadImageView(context);
        this.jYv.setId(R.id.pb_title_user_image);
        this.jYv.setIsRound(true);
        this.jYv.setBorderWidth(l.getDimens(context, R.dimen.tbds1));
        this.jYv.setBorderColor(am.getColor(R.color.cp_border_b));
        this.jYv.setOnClickListener(this.ege);
        this.jYv.setPlaceHolder(1);
        this.jYv.setDefaultResource(R.color.cp_bg_line_e);
        this.jYv.setAutoChangeStyle(true);
        this.jYu.addView(this.jYv, new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds58), l.getDimens(context, R.dimen.tbds58)));
        this.gnb = new TextView(context);
        this.gnb.setOnClickListener(this.ege);
        this.gnb.setTextSize(0, l.getDimens(context, R.dimen.tbds34));
        this.gnb.setSingleLine();
        this.gnb.setGravity(17);
        this.gnb.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds14);
        layoutParams.weight = 1.0f;
        this.jYu.addView(this.gnb, layoutParams);
        this.jYw = new PbFirstFloorUserLikeButton(context);
        this.jYw.kgF = this.ege;
        this.jYw.setId(R.id.pb_title_user_like);
        this.jYw.setTextSize(R.dimen.tbds26);
        this.jYw.getStyleConfig().mh(l.getDimens(getContext(), R.dimen.tbds27));
        this.jYw.getStyleConfig().k(R.drawable.ic_icon_pure_add10_svg, 0, true);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds120), l.getDimens(context, R.dimen.tbds58));
        layoutParams2.leftMargin = l.getDimens(context, R.dimen.tbds30);
        this.jYw.setVisibility(8);
        this.jYu.addView(this.jYw, layoutParams2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setPbFragment(PbFragment pbFragment) {
        if (pbFragment != null) {
            this.jYy = pbFragment;
            this.jYv.setPageId(pbFragment.getUniqueId());
        }
    }

    public void setData(e eVar, PostData postData, boolean z) {
        if (eVar != null && eVar.cCy() != null && postData != null && postData.aQx() != null) {
            if (this.jYx == null) {
                bk cCy = eVar.cCy();
                int i = 1;
                if (cCy.aPm()) {
                    i = 4;
                } else if (cCy.aPn()) {
                    i = 6;
                } else if (cCy.aSw()) {
                    i = 7;
                } else if (cCy.aSv()) {
                    i = 5;
                }
                this.jYx = new at(this.jYy.getPageContext(), this.jYw, i);
                this.jYx.l(this.jYy.getUniqueId());
            }
            MetaData aQx = postData.aQx();
            this.jYx.setTid(eVar.getThreadId());
            this.jYx.a(aQx);
            this.jYx.Ay(au.q(eVar));
            this.jYx.setThreadData(eVar.cCy());
            this.uid = aQx.getUserId();
            this.gnb.setText(aQx.getName_show());
            this.jYv.startLoad(o.wj(aQx.getAvater()), 25, false);
            if (eVar.cCy().aSw() || eVar.cCy().aSv()) {
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
                this.jYw.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || metaData.hadConcerned()) {
                this.jYw.setVisibility(8);
            } else {
                this.jYw.setVisibility(0);
            }
        }
    }

    public void am(float f) {
        this.jYz = f;
        float f2 = f > 0.4f ? (f - 0.4f) / 0.6f : 0.0f;
        float f3 = f > 0.6f ? 0.0f : 1.0f - (f / 0.6f);
        if (f2 == 0.0f) {
            this.jYu.setVisibility(8);
        } else {
            this.jYu.setVisibility(0);
            this.jYu.setAlpha(f2);
        }
        if (f3 == 0.0f) {
            this.dyo.setVisibility(8);
            return;
        }
        this.dyo.setVisibility(0);
        this.dyo.setAlpha(f3);
    }

    public float getAlphaForScroll() {
        return this.jYz;
    }

    public void onChangeSkinType(int i) {
        if (this.jYw != null) {
            this.jYw.onChangeSkinType(i);
        }
        if (this.gnb != null) {
            am.setViewTextColor(this.gnb, (int) R.color.cp_cont_b);
        }
        if (this.dyo != null) {
            am.setViewTextColor(this.dyo, (int) R.color.cp_cont_b);
        }
        if (this.jYv != null) {
            this.jYv.setBorderColor(am.getColor(R.color.cp_border_b));
            this.jYv.invalidate();
        }
    }
}
