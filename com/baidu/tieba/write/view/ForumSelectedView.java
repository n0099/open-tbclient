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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ForumSelectedView extends RelativeLayout implements View.OnClickListener {
    private ImageView eNX;
    private TextView iJS;
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
        this.iJS = (TextView) findViewById(R.id.cell_forum_selected_name);
        this.mTipView = (TextView) findViewById(R.id.cell_forum_selected_tip);
        this.eNX = (ImageView) findViewById(R.id.cell_forum_selected_arrow);
        this.mLineView = findViewById(R.id.cell_forum_selected_line);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void setSelectedForum(String str) {
        this.mTipView.setVisibility(8);
        this.iJS.setText(str);
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
            SvgManager.boN().a(this.mIconView, R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.iJS, R.color.cp_cont_b);
            ap.setBackgroundResource(this.mTipView, R.drawable.forum_selected_tip_bg);
            ap.setViewTextColor(this.mTipView, R.color.cp_cont_d);
            SvgManager.boN().a(this.eNX, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundColor(this.mLineView, R.color.cp_bg_line_b);
        }
    }
}
