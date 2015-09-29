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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private TextView ccH;
    private HeadImageView ctl;
    private ImageView ddk;
    private TbImageView ddl;
    private ImageView ddm;
    private TbImageView ddn;
    private ListView ddo;
    private TextView ddp;
    private TextView ddq;
    private UserIconBox ddr;

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
        this.ctl = (HeadImageView) findViewById(i.f.user_head);
        this.ddk = (ImageView) findViewById(i.f.user_head_red_tip);
        this.ddl = (TbImageView) findViewById(i.f.user_vip_icon);
        this.ddm = (ImageView) findViewById(i.f.left_navi_setting_red_tip);
        this.ccH = (TextView) findViewById(i.f.user_name);
        this.ddn = (TbImageView) findViewById(i.f.user_sex);
        this.ddo = (ListView) findViewById(i.f.left_navi_listview);
        this.ddp = (TextView) findViewById(i.f.left_navi_setting);
        this.ddq = (TextView) findViewById(i.f.left_navi_daynight);
        this.ddr = (UserIconBox) findViewById(i.f.user_icon);
        com.baidu.adp.lib.util.k.a(getContext(), this.ddq, 15, 10, 10, 10);
        ajG();
        ayK();
        if (this.ddq != null) {
            if (!Mz()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.ddq.setVisibility(8);
                return;
            }
            this.ddq.setVisibility(0);
        }
    }

    public boolean Mz() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.ddp != null) {
            this.ddp.setOnClickListener(onClickListener);
        }
    }

    public void setUserIconOnClickListener(View.OnClickListener onClickListener) {
        if (this.ddr != null) {
            this.ddr.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.ddq != null) {
            this.ddq.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(TbImageView.a aVar) {
        if (this.ddl != null) {
            this.ddl.setEvent(aVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.ctl != null) {
            this.ctl.setOnClickListener(onClickListener);
        }
        if (this.ccH != null) {
            this.ccH.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.ddo != null) {
            this.ddo.setOnItemClickListener(onItemClickListener);
        }
    }

    private void ajG() {
        if (this.ctl != null) {
            this.ctl.setIsRound(true);
            this.ctl.setDefaultBgResource(0);
            this.ctl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public TbImageView getUserHeadView() {
        return this.ctl;
    }

    public void gG(boolean z) {
        if (this.ddl != null) {
            if (z) {
                this.ddl.setVisibility(0);
            } else {
                this.ddl.setVisibility(8);
            }
        }
    }

    private void ayK() {
        this.ddl.setGifIconSupport(false);
        this.ddl.setVisibility(8);
    }

    public void gH(boolean z) {
        if (this.ddk != null) {
            if (z) {
                am.c(this.ddk, i.e.icon_news_down_bar_one);
                this.ddk.setVisibility(0);
                return;
            }
            this.ddk.setImageDrawable(null);
            this.ddk.setVisibility(8);
        }
    }

    public void gI(boolean z) {
        if (this.ddm != null) {
            if (z) {
                am.c(this.ddm, i.e.icon_news_down_bar_one);
                this.ddm.setVisibility(0);
                return;
            }
            this.ddm.setImageDrawable(null);
            this.ddm.setVisibility(8);
        }
    }

    public void lN(String str) {
        if (this.ctl != null && !StringUtils.isNull(str)) {
            this.ctl.setVisibility(0);
            this.ctl.d(str, 25, false);
        }
    }

    public void lO(String str) {
        if (this.ddl != null) {
            if (!StringUtils.isNull(str)) {
                this.ddl.d(str, 21, false);
            } else {
                this.ddl.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.ddn != null) {
            if (i == 1) {
                this.ddn.setVisibility(0);
                this.ddn.setImageResource(i.e.icon_pop_boy);
            } else if (i == 2) {
                this.ddn.setVisibility(0);
                this.ddn.setImageResource(i.e.icon_pop_girl);
            } else {
                this.ddn.setVisibility(8);
            }
        }
    }

    public void bw(List<IconData> list) {
        if (list != null) {
            this.ddr.a(list, 9, getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds34), getResources().getDimensionPixelSize(i.d.ds12), true);
        }
    }

    public void setUserName(String str) {
        if (this.ccH != null) {
            this.ccH.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.ddo != null) {
            this.ddo.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.ddp;
    }

    public TextView getDayNightView() {
        return this.ddq;
    }

    public void setDayNightViewText(String str) {
        if (this.ddq != null) {
            this.ddq.setText(str);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.ctl.setIsNight(z);
        if (this.ddk.getVisibility() == 0) {
            am.c(this.ddk, i.e.icon_news_down_bar_one);
        }
        if (this.ddl.getVisibility() == 0) {
            this.ddl.setIsNight(z);
        }
        if (this.ddn.getVisibility() == 0) {
            this.ddn.setIsNight(z);
        }
        if (this.ddm.getVisibility() == 0) {
            am.c(this.ddm, i.e.icon_news_down_bar_one);
        }
        if (this.ddr != null) {
            this.ddr.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.ddp != null) {
            if (skinType == 2) {
                am.b(this.ddp, i.c.s_left_navi_setting, 1);
            } else {
                am.b(this.ddp, i.c.left_navi_setting, 1);
            }
        }
        if (this.ddq != null) {
            if (skinType == 2) {
                am.b(this.ddq, i.c.s_left_navi_setting, 1);
            } else {
                am.b(this.ddq, i.c.left_navi_setting, 1);
            }
        }
    }

    public View getUserIconView() {
        return this.ddr;
    }
}
