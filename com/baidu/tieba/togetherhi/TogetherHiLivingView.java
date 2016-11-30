package com.baidu.tieba.togetherhi;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.n;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class TogetherHiLivingView extends FrameLayout implements View.OnClickListener {
    private TbImageView image1;
    private TbImageView image2;
    private TbImageView image3;
    private TbImageView image4;
    private TextView joinNum;
    private TextView livingTag;
    private TextView location;
    private Context mContext;
    private TextView title;
    private n togetherHiInfo;

    public TogetherHiLivingView(Context context) {
        super(context);
        this.mContext = context;
        init(context);
    }

    public TogetherHiLivingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.tb_richtext_togetherhi_living, this);
        int width = ((WindowManager) inflate.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - inflate.getResources().getDimensionPixelSize(r.e.ds64);
        this.image1 = (TbImageView) inflate.findViewById(r.g.th_image1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams.height = width / 2;
        layoutParams.width = width / 2;
        this.image1.setLayoutParams(layoutParams);
        this.image1.setDefaultErrorResource(r.f.th_photo_bg);
        this.image2 = (TbImageView) inflate.findViewById(r.g.th_image2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.image2.getLayoutParams();
        layoutParams2.height = width / 2;
        layoutParams2.width = width / 2;
        this.image2.setLayoutParams(layoutParams2);
        this.image2.setDefaultErrorResource(r.f.th_photo_bg);
        this.image3 = (TbImageView) inflate.findViewById(r.g.th_image3);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.image3.getLayoutParams();
        layoutParams3.height = width / 2;
        layoutParams3.width = width / 2;
        this.image3.setLayoutParams(layoutParams3);
        this.image3.setDefaultErrorResource(r.f.th_photo_bg);
        this.image4 = (TbImageView) inflate.findViewById(r.g.th_image4);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.image4.getLayoutParams();
        layoutParams4.height = width / 2;
        layoutParams4.width = width / 2;
        this.image4.setLayoutParams(layoutParams2);
        this.image4.setDefaultErrorResource(r.f.th_photo_bg);
        this.livingTag = (TextView) inflate.findViewById(r.g.th_living);
        this.title = (TextView) inflate.findViewById(r.g.th_title);
        this.joinNum = (TextView) inflate.findViewById(r.g.th_join_num);
        this.location = (TextView) inflate.findViewById(r.g.th_location);
        inflate.setOnClickListener(this);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setData(n nVar) {
        if (nVar == null) {
            setVisibility(8);
            return;
        }
        this.togetherHiInfo = nVar;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (nVar.VD == 2) {
            this.livingTag.setVisibility(0);
        } else {
            this.livingTag.setVisibility(8);
        }
        List<String> list = nVar.photoList;
        int size = list == null ? 0 : list.size();
        if (list != null && size > 0) {
            this.image1.c(list.get(0), 13, false);
        } else {
            this.image1.c(null, 13, false);
        }
        if (list != null && size > 1) {
            this.image2.c(list.get(1), 13, false);
        } else {
            this.image2.c(null, 13, false);
        }
        if (list != null && size > 2) {
            this.image3.c(list.get(2), 13, false);
        } else {
            this.image3.setDefaultResource(r.f.th_photo_bg);
        }
        if (list != null && size > 3) {
            this.image4.c(list.get(3), 13, false);
        } else {
            this.image4.setDefaultResource(r.f.th_photo_bg);
        }
        this.title.setText(nVar.Vx);
        this.joinNum.setText(Integer.toString(nVar.VA));
        if (TextUtils.isEmpty(nVar.location)) {
            this.location.setVisibility(8);
        } else {
            this.location.setVisibility(0);
            this.location.setText(nVar.location);
        }
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void reset() {
        this.image1.setImageResource(0);
        this.image2.setImageResource(0);
        this.image3.setImageResource(0);
        this.image4.setImageResource(0);
        this.livingTag.setVisibility(8);
        this.title.setText("");
        this.joinNum.setText("");
        this.location.setText("");
        setTag(null);
    }

    public void onChangeSkinType(int i) {
        at.c(this.livingTag, r.d.cp_cont_g, 1);
        at.c(this.title, r.d.cp_cont_g, 1);
        at.c(this.joinNum, r.d.cp_cont_g, 1);
        at.c(this.location, r.d.cp_cont_g, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c11151");
        ThActivityDetailActivityConfig thActivityDetailActivityConfig = new ThActivityDetailActivityConfig(this.mContext);
        thActivityDetailActivityConfig.createActivityDetailConfig(Long.toString(this.togetherHiInfo.Vy), this.togetherHiInfo.Vx, this.togetherHiInfo.startTime, this.togetherHiInfo.Vz, this.togetherHiInfo.location, this.togetherHiInfo.VB, ThActivityDetailActivityConfig.TH_FROM_PB);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, thActivityDetailActivityConfig));
    }

    public static b<View> createGraffitiViewPool(Context context, int i) {
        return new b<>(new dr(context), i, 0);
    }
}
