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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TextView bHU;
    private HeadImageView bWl;
    private ImageView cws;
    private TbImageView cwt;
    private ImageView cwu;
    private TbImageView cwv;
    private ListView cww;
    private TextView cwx;
    private TextView cwy;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.hr().a(getContext(), r.main_tab_left_navigation, this, true);
        setOrientation(1);
        this.bWl = (HeadImageView) findViewById(q.user_head);
        this.cws = (ImageView) findViewById(q.user_head_red_tip);
        this.cwt = (TbImageView) findViewById(q.user_vip_icon);
        this.cwu = (ImageView) findViewById(q.left_navi_setting_red_tip);
        this.bHU = (TextView) findViewById(q.user_name);
        this.cwv = (TbImageView) findViewById(q.user_sex);
        this.cww = (ListView) findViewById(q.left_navi_listview);
        this.cwx = (TextView) findViewById(q.left_navi_setting);
        this.cwy = (TextView) findViewById(q.left_navi_daynight);
        com.baidu.adp.lib.util.n.a(getContext(), this.cwy, 15, 10, 10, 10);
        afp();
        aqy();
        if (this.cwy != null) {
            if (!LK()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.cwy.setVisibility(8);
                return;
            }
            this.cwy.setVisibility(0);
        }
    }

    public boolean LK() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.cwx != null) {
            this.cwx.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.cwy != null) {
            this.cwy.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(com.baidu.tbadk.widget.n nVar) {
        if (this.cwt != null) {
            this.cwt.setEvent(nVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.bWl != null) {
            this.bWl.setOnClickListener(onClickListener);
        }
        if (this.bHU != null) {
            this.bHU.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.cww != null) {
            this.cww.setOnItemClickListener(onItemClickListener);
        }
    }

    private void afp() {
        if (this.bWl != null) {
            this.bWl.setIsRound(true);
            this.bWl.setDefaultBgResource(0);
            this.bWl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bWl.setDefaultResource(com.baidu.tieba.p.pic_mycenter_avatar_def);
        }
    }

    public TbImageView getUserHeadView() {
        return this.bWl;
    }

    public void ft(boolean z) {
        if (this.cwt != null) {
            if (z) {
                this.cwt.setVisibility(0);
            } else {
                this.cwt.setVisibility(8);
            }
        }
    }

    private void aqy() {
        this.cwt.setGifIconSupport(false);
        this.cwt.setVisibility(8);
    }

    public void fu(boolean z) {
        if (this.cws != null) {
            if (z) {
                ay.c(this.cws, com.baidu.tieba.p.icon_news_down_bar_one);
                this.cws.setVisibility(0);
                return;
            }
            this.cws.setImageDrawable(null);
            this.cws.setVisibility(8);
        }
    }

    public void fv(boolean z) {
        if (this.cwu != null) {
            if (z) {
                ay.c(this.cwu, com.baidu.tieba.p.icon_news_down_bar_one);
                this.cwu.setVisibility(0);
                return;
            }
            this.cwu.setImageDrawable(null);
            this.cwu.setVisibility(8);
        }
    }

    public void jN(String str) {
        if (this.bWl != null && !StringUtils.isNull(str)) {
            this.bWl.setVisibility(0);
            this.bWl.c(str, 25, false);
        }
    }

    public void jO(String str) {
        if (this.cwt != null) {
            if (!StringUtils.isNull(str)) {
                this.cwt.c(str, 21, false);
            } else {
                this.cwt.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.cwv != null) {
            if (i == 1) {
                this.cwv.setVisibility(0);
                this.cwv.setImageResource(com.baidu.tieba.p.icon_pop_boy);
            } else if (i == 2) {
                this.cwv.setVisibility(0);
                this.cwv.setImageResource(com.baidu.tieba.p.icon_pop_girl);
            } else {
                this.cwv.setVisibility(8);
            }
        }
    }

    public void setUserName(String str) {
        if (this.bHU != null) {
            this.bHU.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.cww != null) {
            this.cww.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.cwx;
    }

    public TextView getDayNightView() {
        return this.cwy;
    }

    public void setDayNightViewText(String str) {
        if (this.cwy != null) {
            this.cwy.setText(str);
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.bWl.setIsNight(z);
        if (this.cws.getVisibility() == 0) {
            ay.c(this.cws, com.baidu.tieba.p.icon_news_down_bar_one);
        }
        if (this.cwt.getVisibility() == 0) {
            this.cwt.setIsNight(z);
        }
        if (this.cwv.getVisibility() == 0) {
            this.cwv.setIsNight(z);
        }
        if (this.cwu.getVisibility() == 0) {
            ay.c(this.cwu, com.baidu.tieba.p.icon_news_down_bar_one);
        }
    }
}
