package com.baidu.tieba.tbadkCore.f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private TextView cdt;
    private HeadImageView cuS;
    private TbImageView dcA;
    private ListView dcB;
    private TextView dcC;
    private TextView dcD;
    private UserIconBox dcE;
    private ImageView dcx;
    private TbImageView dcy;
    private ImageView dcz;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(i.g.main_tab_left_navigation, (ViewGroup) this, true);
        setOrientation(1);
        this.cuS = (HeadImageView) findViewById(i.f.user_head);
        this.dcx = (ImageView) findViewById(i.f.user_head_red_tip);
        this.dcy = (TbImageView) findViewById(i.f.user_vip_icon);
        this.dcz = (ImageView) findViewById(i.f.left_navi_setting_red_tip);
        this.cdt = (TextView) findViewById(i.f.user_name);
        this.dcA = (TbImageView) findViewById(i.f.user_sex);
        this.dcB = (ListView) findViewById(i.f.left_navi_listview);
        this.dcC = (TextView) findViewById(i.f.left_navi_setting);
        this.dcD = (TextView) findViewById(i.f.left_navi_daynight);
        this.dcE = (UserIconBox) findViewById(i.f.user_icon);
        com.baidu.adp.lib.util.k.a(getContext(), this.dcD, 15, 10, 10, 10);
        aki();
        axX();
        if (this.dcD != null) {
            if (!ML()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.dcD.setVisibility(8);
                return;
            }
            this.dcD.setVisibility(0);
        }
    }

    public boolean ML() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.dcC != null) {
            this.dcC.setOnClickListener(onClickListener);
        }
    }

    public void setUserIconOnClickListener(View.OnClickListener onClickListener) {
        if (this.dcE != null) {
            this.dcE.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.dcD != null) {
            this.dcD.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(TbImageView.a aVar) {
        if (this.dcy != null) {
            this.dcy.setEvent(aVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.cuS != null) {
            this.cuS.setOnClickListener(onClickListener);
        }
        if (this.cdt != null) {
            this.cdt.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.dcB != null) {
            this.dcB.setOnItemClickListener(onItemClickListener);
        }
    }

    private void aki() {
        if (this.cuS != null) {
            this.cuS.setIsRound(true);
            this.cuS.setDefaultBgResource(0);
            this.cuS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public TbImageView getUserHeadView() {
        return this.cuS;
    }

    public void gx(boolean z) {
        if (this.dcy != null) {
            if (z) {
                this.dcy.setVisibility(0);
            } else {
                this.dcy.setVisibility(8);
            }
        }
    }

    private void axX() {
        this.dcy.setGifIconSupport(false);
        this.dcy.setVisibility(8);
    }

    public void gy(boolean z) {
        if (this.dcx != null) {
            if (z) {
                an.c(this.dcx, i.e.icon_news_down_bar_one);
                this.dcx.setVisibility(0);
                return;
            }
            this.dcx.setImageDrawable(null);
            this.dcx.setVisibility(8);
        }
    }

    public void gz(boolean z) {
        if (this.dcz != null) {
            if (z) {
                an.c(this.dcz, i.e.icon_news_down_bar_one);
                this.dcz.setVisibility(0);
                return;
            }
            this.dcz.setImageDrawable(null);
            this.dcz.setVisibility(8);
        }
    }

    public void lH(String str) {
        if (this.cuS != null && !StringUtils.isNull(str)) {
            this.cuS.setVisibility(0);
            this.cuS.d(str, 25, false);
        }
    }

    public void lI(String str) {
        if (this.dcy != null) {
            if (!StringUtils.isNull(str)) {
                this.dcy.d(str, 21, false);
            } else {
                this.dcy.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.dcA != null) {
            if (i == 1) {
                this.dcA.setVisibility(0);
                this.dcA.setImageResource(i.e.icon_pop_boy);
            } else if (i == 2) {
                this.dcA.setVisibility(0);
                this.dcA.setImageResource(i.e.icon_pop_girl);
            } else {
                this.dcA.setVisibility(8);
            }
        }
    }

    public void bA(List<IconData> list) {
        if (list != null) {
            this.dcE.a(list, 9, getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds12), true);
        }
    }

    public void setUserName(String str) {
        if (this.cdt != null) {
            this.cdt.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.dcB != null) {
            this.dcB.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.dcC;
    }

    public TextView getDayNightView() {
        return this.dcD;
    }

    public void setDayNightViewText(String str) {
        if (this.dcD != null) {
            this.dcD.setText(str);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.cuS.setIsNight(z);
        if (this.dcx.getVisibility() == 0) {
            an.c(this.dcx, i.e.icon_news_down_bar_one);
        }
        if (this.dcy.getVisibility() == 0) {
            this.dcy.setIsNight(z);
        }
        if (this.dcA.getVisibility() == 0) {
            this.dcA.setIsNight(z);
        }
        if (this.dcz.getVisibility() == 0) {
            an.c(this.dcz, i.e.icon_news_down_bar_one);
        }
        if (this.dcE != null) {
            this.dcE.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.dcC != null) {
            if (skinType == 2) {
                an.b(this.dcC, i.c.s_left_navi_setting, 1);
            } else {
                an.b(this.dcC, i.c.left_navi_setting, 1);
            }
        }
        if (this.dcD != null) {
            if (skinType == 2) {
                an.b(this.dcD, i.c.s_left_navi_setting, 1);
            } else {
                an.b(this.dcD, i.c.left_navi_setting, 1);
            }
        }
    }

    public View getUserIconView() {
        return this.dcE;
    }
}
