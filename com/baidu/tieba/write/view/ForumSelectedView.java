package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ForumSelectedView extends RelativeLayout implements View.OnClickListener {
    private ImageView fhs;
    private TextView joX;
    private ImageView mIconView;
    private View mLineView;
    private int mSkinType;
    private TextView mTipView;

    public ForumSelectedView(Context context) {
        this(context, null);
    }

    public ForumSelectedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForumSelectedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.cell_forum_selected_layout, (ViewGroup) this, true);
        this.mIconView = (ImageView) findViewById(R.id.cell_forum_selected_icon);
        this.joX = (TextView) findViewById(R.id.cell_forum_selected_name);
        this.mTipView = (TextView) findViewById(R.id.cell_forum_selected_tip);
        this.fhs = (ImageView) findViewById(R.id.cell_forum_selected_arrow);
        this.mLineView = findViewById(R.id.cell_forum_selected_line);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setSelectedForum(String str) {
        this.mTipView.setVisibility(8);
        this.joX.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectForumConfig(getContext())));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundResource(this, R.drawable.forum_selected_view_bg);
            this.mIconView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_ba16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            ap.setViewTextColor(this.joX, R.color.CAM_X0105);
            ap.setViewTextColor(this.mTipView, R.color.CAM_X0109);
            c.br(this.mTipView).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            SvgManager.bsR().a(this.fhs, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundColor(this.mLineView, R.color.CAM_X0210);
        }
    }
}
