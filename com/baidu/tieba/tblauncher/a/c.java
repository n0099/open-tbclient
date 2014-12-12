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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.p;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private HeadImageView bJt;
    private TextView bxR;
    private ImageView ccj;
    private TbImageView cck;
    private ImageView ccl;
    private TbImageView ccm;
    private ListView ccn;
    private TextView cco;
    private TextView ccp;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ek().a(getContext(), x.main_tab_left_navigation, this, true);
        setOrientation(1);
        this.bJt = (HeadImageView) findViewById(w.user_head);
        this.ccj = (ImageView) findViewById(w.user_head_red_tip);
        this.cck = (TbImageView) findViewById(w.user_vip_icon);
        this.ccl = (ImageView) findViewById(w.left_navi_setting_red_tip);
        this.bxR = (TextView) findViewById(w.user_name);
        this.ccm = (TbImageView) findViewById(w.user_sex);
        this.ccn = (ListView) findViewById(w.left_navi_listview);
        this.cco = (TextView) findViewById(w.left_navi_setting);
        this.ccp = (TextView) findViewById(w.left_navi_daynight);
        abi();
        ajk();
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.cco != null) {
            this.cco.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.ccp != null) {
            this.ccp.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(p pVar) {
        if (this.cck != null) {
            this.cck.setEvent(pVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.bJt != null) {
            this.bJt.setOnClickListener(onClickListener);
        }
        if (this.bxR != null) {
            this.bxR.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.ccn != null) {
            this.ccn.setOnItemClickListener(onItemClickListener);
        }
    }

    private void abi() {
        if (this.bJt != null) {
            this.bJt.setIsRound(true);
            this.bJt.setDefaultBgResource(0);
            this.bJt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bJt.setDefaultResource(v.pic_mycenter_avatar_def);
        }
    }

    public TbImageView getUserHeadView() {
        return this.bJt;
    }

    public void eG(boolean z) {
        if (this.cck != null) {
            if (z) {
                this.cck.setVisibility(0);
            } else {
                this.cck.setVisibility(8);
            }
        }
    }

    private void ajk() {
        this.cck.setGifIconSupport(false);
        this.cck.setSupportNoImage(false);
        this.cck.setVisibility(8);
    }

    public void eH(boolean z) {
        if (this.ccj != null) {
            if (z) {
                ax.c(this.ccj, v.icon_news_down_bar_one);
                this.ccj.setVisibility(0);
                return;
            }
            this.ccj.setImageDrawable(null);
            this.ccj.setVisibility(8);
        }
    }

    public void eI(boolean z) {
        if (this.ccl != null) {
            if (z) {
                ax.c(this.ccl, v.icon_news_down_bar_one);
                this.ccl.setVisibility(0);
                return;
            }
            this.ccl.setImageDrawable(null);
            this.ccl.setVisibility(8);
        }
    }

    public void is(String str) {
        if (this.bJt != null) {
            if (!StringUtils.isNull(str)) {
                this.bJt.setVisibility(0);
                this.bJt.d(str, 25, false);
                return;
            }
            this.bJt.setVisibility(8);
        }
    }

    public void it(String str) {
        if (this.cck != null) {
            if (!StringUtils.isNull(str)) {
                this.cck.d(str, 21, false);
            } else {
                this.cck.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.ccm != null) {
            if (i == 1) {
                this.ccm.setVisibility(0);
                this.ccm.setImageResource(v.icon_pop_boy);
            } else if (i == 2) {
                this.ccm.setVisibility(0);
                this.ccm.setImageResource(v.icon_pop_girl);
            } else {
                this.ccm.setVisibility(8);
            }
        }
    }

    public void setUserName(String str) {
        if (this.bxR != null) {
            this.bxR.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.ccn != null) {
            this.ccn.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.cco;
    }

    public TextView getDayNightView() {
        return this.ccp;
    }

    public void setDayNightViewText(String str) {
        if (this.ccp != null) {
            this.ccp.setText(str);
        }
    }

    public void b(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.g.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        this.bJt.setIsNight(z);
        if (this.ccj.getVisibility() == 0) {
            ax.c(this.ccj, v.icon_news_down_bar_one);
        }
        if (this.cck.getVisibility() == 0) {
            this.cck.setIsNight(z);
        }
        if (this.ccm.getVisibility() == 0) {
            this.ccm.setIsNight(z);
        }
        if (this.ccl.getVisibility() == 0) {
            ax.c(this.ccl, v.icon_news_down_bar_one);
        }
    }
}
