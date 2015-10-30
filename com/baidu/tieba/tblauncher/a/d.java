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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private TextView ccS;
    private HeadImageView ctw;
    private ImageView ddK;
    private TbImageView ddL;
    private ImageView ddM;
    private TbImageView ddN;
    private ListView ddO;
    private TextView ddP;
    private TextView ddQ;
    private UserIconBox ddR;

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
        this.ctw = (HeadImageView) findViewById(i.f.user_head);
        this.ddK = (ImageView) findViewById(i.f.user_head_red_tip);
        this.ddL = (TbImageView) findViewById(i.f.user_vip_icon);
        this.ddM = (ImageView) findViewById(i.f.left_navi_setting_red_tip);
        this.ccS = (TextView) findViewById(i.f.user_name);
        this.ddN = (TbImageView) findViewById(i.f.user_sex);
        this.ddO = (ListView) findViewById(i.f.left_navi_listview);
        this.ddP = (TextView) findViewById(i.f.left_navi_setting);
        this.ddQ = (TextView) findViewById(i.f.left_navi_daynight);
        this.ddR = (UserIconBox) findViewById(i.f.user_icon);
        com.baidu.adp.lib.util.k.a(getContext(), this.ddQ, 15, 10, 10, 10);
        ajC();
        ayQ();
        if (this.ddQ != null) {
            if (!Mv()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.ddQ.setVisibility(8);
                return;
            }
            this.ddQ.setVisibility(0);
        }
    }

    public boolean Mv() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.ddP != null) {
            this.ddP.setOnClickListener(onClickListener);
        }
    }

    public void setUserIconOnClickListener(View.OnClickListener onClickListener) {
        if (this.ddR != null) {
            this.ddR.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.ddQ != null) {
            this.ddQ.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(TbImageView.a aVar) {
        if (this.ddL != null) {
            this.ddL.setEvent(aVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.ctw != null) {
            this.ctw.setOnClickListener(onClickListener);
        }
        if (this.ccS != null) {
            this.ccS.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.ddO != null) {
            this.ddO.setOnItemClickListener(onItemClickListener);
        }
    }

    private void ajC() {
        if (this.ctw != null) {
            this.ctw.setIsRound(true);
            this.ctw.setDefaultBgResource(0);
            this.ctw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public TbImageView getUserHeadView() {
        return this.ctw;
    }

    public void gG(boolean z) {
        if (this.ddL != null) {
            if (z) {
                this.ddL.setVisibility(0);
            } else {
                this.ddL.setVisibility(8);
            }
        }
    }

    private void ayQ() {
        this.ddL.setGifIconSupport(false);
        this.ddL.setVisibility(8);
    }

    public void gH(boolean z) {
        if (this.ddK != null) {
            if (z) {
                an.c(this.ddK, i.e.icon_news_down_bar_one);
                this.ddK.setVisibility(0);
                return;
            }
            this.ddK.setImageDrawable(null);
            this.ddK.setVisibility(8);
        }
    }

    public void gI(boolean z) {
        if (this.ddM != null) {
            if (z) {
                an.c(this.ddM, i.e.icon_news_down_bar_one);
                this.ddM.setVisibility(0);
                return;
            }
            this.ddM.setImageDrawable(null);
            this.ddM.setVisibility(8);
        }
    }

    public void lQ(String str) {
        if (this.ctw != null && !StringUtils.isNull(str)) {
            this.ctw.setVisibility(0);
            this.ctw.d(str, 25, false);
        }
    }

    public void lR(String str) {
        if (this.ddL != null) {
            if (!StringUtils.isNull(str)) {
                this.ddL.d(str, 21, false);
            } else {
                this.ddL.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.ddN != null) {
            if (i == 1) {
                this.ddN.setVisibility(0);
                this.ddN.setImageResource(i.e.icon_pop_boy);
            } else if (i == 2) {
                this.ddN.setVisibility(0);
                this.ddN.setImageResource(i.e.icon_pop_girl);
            } else {
                this.ddN.setVisibility(8);
            }
        }
    }

    public void bx(List<IconData> list) {
        if (list != null) {
            this.ddR.a(list, 9, getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds12), true);
        }
    }

    public void setUserName(String str) {
        if (this.ccS != null) {
            this.ccS.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.ddO != null) {
            this.ddO.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.ddP;
    }

    public TextView getDayNightView() {
        return this.ddQ;
    }

    public void setDayNightViewText(String str) {
        if (this.ddQ != null) {
            this.ddQ.setText(str);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.ctw.setIsNight(z);
        if (this.ddK.getVisibility() == 0) {
            an.c(this.ddK, i.e.icon_news_down_bar_one);
        }
        if (this.ddL.getVisibility() == 0) {
            this.ddL.setIsNight(z);
        }
        if (this.ddN.getVisibility() == 0) {
            this.ddN.setIsNight(z);
        }
        if (this.ddM.getVisibility() == 0) {
            an.c(this.ddM, i.e.icon_news_down_bar_one);
        }
        if (this.ddR != null) {
            this.ddR.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.ddP != null) {
            if (skinType == 2) {
                an.b(this.ddP, i.c.s_left_navi_setting, 1);
            } else {
                an.b(this.ddP, i.c.left_navi_setting, 1);
            }
        }
        if (this.ddQ != null) {
            if (skinType == 2) {
                an.b(this.ddQ, i.c.s_left_navi_setting, 1);
            } else {
                an.b(this.ddQ, i.c.left_navi_setting, 1);
            }
        }
    }

    public View getUserIconView() {
        return this.ddR;
    }
}
