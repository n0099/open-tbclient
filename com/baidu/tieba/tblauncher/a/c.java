package com.baidu.tieba.tblauncher.a;

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TextView bYV;
    private ImageView cVC;
    private TbImageView cVD;
    private ImageView cVE;
    private TbImageView cVF;
    private ListView cVG;
    private TextView cVH;
    private TextView cVI;
    private UserIconBox cVJ;
    private HeadImageView cnF;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(i.g.main_tab_left_navigation, (ViewGroup) this, true);
        setOrientation(1);
        this.cnF = (HeadImageView) findViewById(i.f.user_head);
        this.cVC = (ImageView) findViewById(i.f.user_head_red_tip);
        this.cVD = (TbImageView) findViewById(i.f.user_vip_icon);
        this.cVE = (ImageView) findViewById(i.f.left_navi_setting_red_tip);
        this.bYV = (TextView) findViewById(i.f.user_name);
        this.cVF = (TbImageView) findViewById(i.f.user_sex);
        this.cVG = (ListView) findViewById(i.f.left_navi_listview);
        this.cVH = (TextView) findViewById(i.f.left_navi_setting);
        this.cVI = (TextView) findViewById(i.f.left_navi_daynight);
        this.cVJ = (UserIconBox) findViewById(i.f.user_icon);
        com.baidu.adp.lib.util.k.a(getContext(), this.cVI, 15, 10, 10, 10);
        ahF();
        aws();
        if (this.cVI != null) {
            if (!MA()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.cVI.setVisibility(8);
                return;
            }
            this.cVI.setVisibility(0);
        }
    }

    public boolean MA() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.cVH != null) {
            this.cVH.setOnClickListener(onClickListener);
        }
    }

    public void setUserIconOnClickListener(View.OnClickListener onClickListener) {
        if (this.cVJ != null) {
            this.cVJ.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.cVI != null) {
            this.cVI.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(TbImageView.a aVar) {
        if (this.cVD != null) {
            this.cVD.setEvent(aVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.cnF != null) {
            this.cnF.setOnClickListener(onClickListener);
        }
        if (this.bYV != null) {
            this.bYV.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.cVG != null) {
            this.cVG.setOnItemClickListener(onItemClickListener);
        }
    }

    private void ahF() {
        if (this.cnF != null) {
            this.cnF.setIsRound(true);
            this.cnF.setDefaultBgResource(0);
            this.cnF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public TbImageView getUserHeadView() {
        return this.cnF;
    }

    public void gw(boolean z) {
        if (this.cVD != null) {
            if (z) {
                this.cVD.setVisibility(0);
            } else {
                this.cVD.setVisibility(8);
            }
        }
    }

    private void aws() {
        this.cVD.setGifIconSupport(false);
        this.cVD.setVisibility(8);
    }

    public void gx(boolean z) {
        if (this.cVC != null) {
            if (z) {
                al.c(this.cVC, i.e.icon_news_down_bar_one);
                this.cVC.setVisibility(0);
                return;
            }
            this.cVC.setImageDrawable(null);
            this.cVC.setVisibility(8);
        }
    }

    public void gy(boolean z) {
        if (this.cVE != null) {
            if (z) {
                al.c(this.cVE, i.e.icon_news_down_bar_one);
                this.cVE.setVisibility(0);
                return;
            }
            this.cVE.setImageDrawable(null);
            this.cVE.setVisibility(8);
        }
    }

    public void ln(String str) {
        if (this.cnF != null && !StringUtils.isNull(str)) {
            this.cnF.setVisibility(0);
            this.cnF.d(str, 25, false);
        }
    }

    public void lo(String str) {
        if (this.cVD != null) {
            if (!StringUtils.isNull(str)) {
                this.cVD.d(str, 21, false);
            } else {
                this.cVD.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.cVF != null) {
            if (i == 1) {
                this.cVF.setVisibility(0);
                this.cVF.setImageResource(i.e.icon_pop_boy);
            } else if (i == 2) {
                this.cVF.setVisibility(0);
                this.cVF.setImageResource(i.e.icon_pop_girl);
            } else {
                this.cVF.setVisibility(8);
            }
        }
    }

    public void bt(List<IconData> list) {
        if (list != null) {
            this.cVJ.a(list, 9, getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds12), true);
        }
    }

    public void setUserName(String str) {
        if (this.bYV != null) {
            this.bYV.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.cVG != null) {
            this.cVG.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.cVH;
    }

    public TextView getDayNightView() {
        return this.cVI;
    }

    public void setDayNightViewText(String str) {
        if (this.cVI != null) {
            this.cVI.setText(str);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.cnF.setIsNight(z);
        if (this.cVC.getVisibility() == 0) {
            al.c(this.cVC, i.e.icon_news_down_bar_one);
        }
        if (this.cVD.getVisibility() == 0) {
            this.cVD.setIsNight(z);
        }
        if (this.cVF.getVisibility() == 0) {
            this.cVF.setIsNight(z);
        }
        if (this.cVE.getVisibility() == 0) {
            al.c(this.cVE, i.e.icon_news_down_bar_one);
        }
        if (this.cVJ != null) {
            this.cVJ.cO(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    public View getUserIconView() {
        return this.cVJ;
    }
}
