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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.p;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private HeadImageView bLe;
    private TextView bzA;
    private ImageView cdC;
    private TbImageView cdD;
    private ImageView cdE;
    private TbImageView cdF;
    private ListView cdG;
    private TextView cdH;
    private TextView cdI;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ei().a(getContext(), x.main_tab_left_navigation, this, true);
        setOrientation(1);
        this.bLe = (HeadImageView) findViewById(w.user_head);
        this.cdC = (ImageView) findViewById(w.user_head_red_tip);
        this.cdD = (TbImageView) findViewById(w.user_vip_icon);
        this.cdE = (ImageView) findViewById(w.left_navi_setting_red_tip);
        this.bzA = (TextView) findViewById(w.user_name);
        this.cdF = (TbImageView) findViewById(w.user_sex);
        this.cdG = (ListView) findViewById(w.left_navi_listview);
        this.cdH = (TextView) findViewById(w.left_navi_setting);
        this.cdI = (TextView) findViewById(w.left_navi_daynight);
        abM();
        ajG();
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.cdH != null) {
            this.cdH.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.cdI != null) {
            this.cdI.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(p pVar) {
        if (this.cdD != null) {
            this.cdD.setEvent(pVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.bLe != null) {
            this.bLe.setOnClickListener(onClickListener);
        }
        if (this.bzA != null) {
            this.bzA.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.cdG != null) {
            this.cdG.setOnItemClickListener(onItemClickListener);
        }
    }

    private void abM() {
        if (this.bLe != null) {
            this.bLe.setIsRound(true);
            this.bLe.setDefaultBgResource(0);
            this.bLe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bLe.setDefaultResource(v.pic_mycenter_avatar_def);
        }
    }

    public TbImageView getUserHeadView() {
        return this.bLe;
    }

    public void eL(boolean z) {
        if (this.cdD != null) {
            if (z) {
                this.cdD.setVisibility(0);
            } else {
                this.cdD.setVisibility(8);
            }
        }
    }

    private void ajG() {
        this.cdD.setGifIconSupport(false);
        this.cdD.setSupportNoImage(false);
        this.cdD.setVisibility(8);
    }

    public void eM(boolean z) {
        if (this.cdC != null) {
            if (z) {
                bc.c(this.cdC, v.icon_news_down_bar_one);
                this.cdC.setVisibility(0);
                return;
            }
            this.cdC.setImageDrawable(null);
            this.cdC.setVisibility(8);
        }
    }

    public void eN(boolean z) {
        if (this.cdE != null) {
            if (z) {
                bc.c(this.cdE, v.icon_news_down_bar_one);
                this.cdE.setVisibility(0);
                return;
            }
            this.cdE.setImageDrawable(null);
            this.cdE.setVisibility(8);
        }
    }

    public void iA(String str) {
        if (this.bLe != null) {
            if (!StringUtils.isNull(str)) {
                this.bLe.setVisibility(0);
                this.bLe.d(str, 25, false);
                return;
            }
            this.bLe.setVisibility(8);
        }
    }

    public void iB(String str) {
        if (this.cdD != null) {
            if (!StringUtils.isNull(str)) {
                this.cdD.d(str, 21, false);
            } else {
                this.cdD.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.cdF != null) {
            if (i == 1) {
                this.cdF.setVisibility(0);
                this.cdF.setImageResource(v.icon_pop_boy);
            } else if (i == 2) {
                this.cdF.setVisibility(0);
                this.cdF.setImageResource(v.icon_pop_girl);
            } else {
                this.cdF.setVisibility(8);
            }
        }
    }

    public void setUserName(String str) {
        if (this.bzA != null) {
            this.bzA.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.cdG != null) {
            this.cdG.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.cdH;
    }

    public TextView getDayNightView() {
        return this.cdI;
    }

    public void setDayNightViewText(String str) {
        if (this.cdI != null) {
            this.cdI.setText(str);
        }
    }

    public void c(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.g.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        this.bLe.setIsNight(z);
        if (this.cdC.getVisibility() == 0) {
            bc.c(this.cdC, v.icon_news_down_bar_one);
        }
        if (this.cdD.getVisibility() == 0) {
            this.cdD.setIsNight(z);
        }
        if (this.cdF.getVisibility() == 0) {
            this.cdF.setIsNight(z);
        }
        if (this.cdE.getVisibility() == 0) {
            bc.c(this.cdE, v.icon_news_down_bar_one);
        }
    }
}
