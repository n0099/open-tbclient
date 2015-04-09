package com.baidu.tieba.tblauncher.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TextView bEZ;
    private HeadImageView bTE;
    private ImageView csi;
    private TbImageView csj;
    private ImageView csk;
    private TbImageView csl;
    private ListView csm;
    private TextView csn;
    private TextView cso;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.hH().a(getContext(), w.main_tab_left_navigation, this, true);
        setOrientation(1);
        this.bTE = (HeadImageView) findViewById(v.user_head);
        this.csi = (ImageView) findViewById(v.user_head_red_tip);
        this.csj = (TbImageView) findViewById(v.user_vip_icon);
        this.csk = (ImageView) findViewById(v.left_navi_setting_red_tip);
        this.bEZ = (TextView) findViewById(v.user_name);
        this.csl = (TbImageView) findViewById(v.user_sex);
        this.csm = (ListView) findViewById(v.left_navi_listview);
        this.csn = (TextView) findViewById(v.left_navi_setting);
        this.cso = (TextView) findViewById(v.left_navi_daynight);
        com.baidu.adp.lib.util.n.a(getContext(), this.cso, 15, 10, 10, 10);
        aek();
        aoJ();
        if (this.cso != null) {
            if (!KF()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.cso.setVisibility(8);
                return;
            }
            this.cso.setVisibility(0);
        }
    }

    public boolean KF() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.csn != null) {
            this.csn.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.cso != null) {
            this.cso.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(com.baidu.tbadk.widget.n nVar) {
        if (this.csj != null) {
            this.csj.setEvent(nVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.bTE != null) {
            this.bTE.setOnClickListener(onClickListener);
        }
        if (this.bEZ != null) {
            this.bEZ.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.csm != null) {
            this.csm.setOnItemClickListener(onItemClickListener);
        }
    }

    private void aek() {
        if (this.bTE != null) {
            this.bTE.setIsRound(true);
            this.bTE.setDefaultBgResource(0);
            this.bTE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bTE.setDefaultResource(u.pic_mycenter_avatar_def);
        }
    }

    public TbImageView getUserHeadView() {
        return this.bTE;
    }

    public void eX(boolean z) {
        if (this.csj != null) {
            if (z) {
                this.csj.setVisibility(0);
            } else {
                this.csj.setVisibility(8);
            }
        }
    }

    private void aoJ() {
        this.csj.setGifIconSupport(false);
        this.csj.setVisibility(8);
    }

    public void eY(boolean z) {
        if (this.csi != null) {
            if (z) {
                ba.c(this.csi, u.icon_news_down_bar_one);
                this.csi.setVisibility(0);
                return;
            }
            this.csi.setImageDrawable(null);
            this.csi.setVisibility(8);
        }
    }

    public void eZ(boolean z) {
        if (this.csk != null) {
            if (z) {
                ba.c(this.csk, u.icon_news_down_bar_one);
                this.csk.setVisibility(0);
                return;
            }
            this.csk.setImageDrawable(null);
            this.csk.setVisibility(8);
        }
    }

    public void iT(String str) {
        if (this.bTE != null && !StringUtils.isNull(str)) {
            this.bTE.setVisibility(0);
            this.bTE.c(str, 25, false);
        }
    }

    public void iU(String str) {
        if (this.csj != null) {
            if (!StringUtils.isNull(str)) {
                this.csj.c(str, 21, false);
            } else {
                this.csj.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.csl != null) {
            if (i == 1) {
                this.csl.setVisibility(0);
                this.csl.setImageResource(u.icon_pop_boy);
            } else if (i == 2) {
                this.csl.setVisibility(0);
                this.csl.setImageResource(u.icon_pop_girl);
            } else {
                this.csl.setVisibility(8);
            }
        }
    }

    public void setUserName(String str) {
        if (this.bEZ != null) {
            this.bEZ.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.csm != null) {
            this.csm.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.csn;
    }

    public TextView getDayNightView() {
        return this.cso;
    }

    public void setDayNightViewText(String str) {
        if (this.cso != null) {
            this.cso.setText(str);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.bTE.setIsNight(z);
        if (this.csi.getVisibility() == 0) {
            ba.c(this.csi, u.icon_news_down_bar_one);
        }
        if (this.csj.getVisibility() == 0) {
            this.csj.setIsNight(z);
        }
        if (this.csl.getVisibility() == 0) {
            this.csl.setIsNight(z);
        }
        if (this.csk.getVisibility() == 0) {
            ba.c(this.csk, u.icon_news_down_bar_one);
        }
    }
}
