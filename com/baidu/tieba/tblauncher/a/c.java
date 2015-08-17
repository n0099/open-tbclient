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
    private TextView bYb;
    private ImageView cMV;
    private TbImageView cMW;
    private ImageView cMX;
    private TbImageView cMY;
    private ListView cMZ;
    private TextView cNa;
    private TextView cNb;
    private UserIconBox cNc;
    private HeadImageView cmD;

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
        this.cmD = (HeadImageView) findViewById(i.f.user_head);
        this.cMV = (ImageView) findViewById(i.f.user_head_red_tip);
        this.cMW = (TbImageView) findViewById(i.f.user_vip_icon);
        this.cMX = (ImageView) findViewById(i.f.left_navi_setting_red_tip);
        this.bYb = (TextView) findViewById(i.f.user_name);
        this.cMY = (TbImageView) findViewById(i.f.user_sex);
        this.cMZ = (ListView) findViewById(i.f.left_navi_listview);
        this.cNa = (TextView) findViewById(i.f.left_navi_setting);
        this.cNb = (TextView) findViewById(i.f.left_navi_daynight);
        this.cNc = (UserIconBox) findViewById(i.f.user_icon);
        com.baidu.adp.lib.util.k.a(getContext(), this.cNb, 15, 10, 10, 10);
        ahn();
        asa();
        if (this.cNb != null) {
            if (!MA()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.cNb.setVisibility(8);
                return;
            }
            this.cNb.setVisibility(0);
        }
    }

    public boolean MA() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.cNa != null) {
            this.cNa.setOnClickListener(onClickListener);
        }
    }

    public void setUserIconOnClickListener(View.OnClickListener onClickListener) {
        if (this.cNc != null) {
            this.cNc.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.cNb != null) {
            this.cNb.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(TbImageView.a aVar) {
        if (this.cMW != null) {
            this.cMW.setEvent(aVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.cmD != null) {
            this.cmD.setOnClickListener(onClickListener);
        }
        if (this.bYb != null) {
            this.bYb.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.cMZ != null) {
            this.cMZ.setOnItemClickListener(onItemClickListener);
        }
    }

    private void ahn() {
        if (this.cmD != null) {
            this.cmD.setIsRound(true);
            this.cmD.setDefaultBgResource(0);
            this.cmD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public TbImageView getUserHeadView() {
        return this.cmD;
    }

    public void fL(boolean z) {
        if (this.cMW != null) {
            if (z) {
                this.cMW.setVisibility(0);
            } else {
                this.cMW.setVisibility(8);
            }
        }
    }

    private void asa() {
        this.cMW.setGifIconSupport(false);
        this.cMW.setVisibility(8);
    }

    public void fM(boolean z) {
        if (this.cMV != null) {
            if (z) {
                al.c(this.cMV, i.e.icon_news_down_bar_one);
                this.cMV.setVisibility(0);
                return;
            }
            this.cMV.setImageDrawable(null);
            this.cMV.setVisibility(8);
        }
    }

    public void fN(boolean z) {
        if (this.cMX != null) {
            if (z) {
                al.c(this.cMX, i.e.icon_news_down_bar_one);
                this.cMX.setVisibility(0);
                return;
            }
            this.cMX.setImageDrawable(null);
            this.cMX.setVisibility(8);
        }
    }

    public void kG(String str) {
        if (this.cmD != null && !StringUtils.isNull(str)) {
            this.cmD.setVisibility(0);
            this.cmD.d(str, 25, false);
        }
    }

    public void kH(String str) {
        if (this.cMW != null) {
            if (!StringUtils.isNull(str)) {
                this.cMW.d(str, 21, false);
            } else {
                this.cMW.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.cMY != null) {
            if (i == 1) {
                this.cMY.setVisibility(0);
                this.cMY.setImageResource(i.e.icon_pop_boy);
            } else if (i == 2) {
                this.cMY.setVisibility(0);
                this.cMY.setImageResource(i.e.icon_pop_girl);
            } else {
                this.cMY.setVisibility(8);
            }
        }
    }

    public void bk(List<IconData> list) {
        if (list != null) {
            this.cNc.a(list, 9, getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds12), true);
        }
    }

    public void setUserName(String str) {
        if (this.bYb != null) {
            this.bYb.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.cMZ != null) {
            this.cMZ.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.cNa;
    }

    public TextView getDayNightView() {
        return this.cNb;
    }

    public void setDayNightViewText(String str) {
        if (this.cNb != null) {
            this.cNb.setText(str);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.cmD.setIsNight(z);
        if (this.cMV.getVisibility() == 0) {
            al.c(this.cMV, i.e.icon_news_down_bar_one);
        }
        if (this.cMW.getVisibility() == 0) {
            this.cMW.setIsNight(z);
        }
        if (this.cMY.getVisibility() == 0) {
            this.cMY.setIsNight(z);
        }
        if (this.cMX.getVisibility() == 0) {
            al.c(this.cMX, i.e.icon_news_down_bar_one);
        }
        if (this.cNc != null) {
            this.cNc.cI(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    public View getUserIconView() {
        return this.cNc;
    }
}
