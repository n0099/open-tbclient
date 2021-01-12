package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mSkinType;
    private EMTextView nXT;
    private EMTextView nXU;
    private ImageView nXV;
    private View nXW;
    private View nXX;
    private ItemCardView nXY;
    private RankStarView nXZ;
    private b nYa;
    private a nYb;
    private boolean nYc;

    /* loaded from: classes7.dex */
    public interface a {
        void ap(float f);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onClose();
    }

    public WriteEvaluationHeaderView(@NonNull Context context) {
        this(context, null);
    }

    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.nYc = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.nXU = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.nXT = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.nXW = findViewById(R.id.write_select_item_relevance);
        this.nXV = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.nXX = findViewById(R.id.item_relevance_line);
        this.nXY = (ItemCardView) findViewById(R.id.item_star_info);
        this.nXZ = (RankStarView) findViewById(R.id.item_set_new_star);
        this.nXZ.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.nXZ.setClickable(true);
        this.nXZ.setStarChangListener(this);
        this.nXY.btA();
        this.nXY.setOnCloseListener(this);
        this.nXY.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.nXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteEvaluationHeaderView.this.dVr();
            }
        });
    }

    public void dVr() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelevanceItemSearchActivityConfig(getContext(), RequestResponseCode.REQUEST_SDK_WEB_VIEW)));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.nXT != null) {
                ao.setViewTextColor(this.nXT, R.color.CAM_X0109);
                c.bv(this.nXT).od(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.nXV != null) {
                SvgManager.bsx().a(this.nXV, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.nXX != null) {
                ao.setBackgroundColor(this.nXX, R.color.CAM_X0210);
            }
            if (this.nXY != null) {
                ao.setBackgroundColor(this.nXY, R.color.CAM_X0206);
            }
            if (this.nXU != null) {
                ao.setViewTextColor(this.nXU, R.color.CAM_X0105);
            }
            if (this.nXZ != null) {
                this.nXZ.onChangeSkinType(skinType);
            }
            if (this.nXZ != null) {
                this.nXZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.nYc) {
            this.nXY.setVisibility(0);
            this.nXX.setVisibility(8);
        }
        this.nXZ.setVisibility(0);
        this.nXZ.setStarCount(0.0f);
        this.nXT.setVisibility(8);
        this.nXY.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.nXZ.getStarCount();
    }

    public void setStarCount(int i) {
        this.nXZ.setStarCount(i);
    }

    public boolean dVs() {
        return this.nXZ.bFM();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void ap(float f) {
        if (this.nYb != null) {
            this.nYb.ap(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.nYc = z;
        this.nXY.setVisibility(8);
        this.nXX.setVisibility(0);
        this.nXW.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.nYa = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.nYb = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.nXY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.nXY.setVisibility(8);
        this.nXX.setVisibility(0);
        this.nXZ.setVisibility(8);
        this.nXT.setVisibility(0);
        if (this.nYa != null) {
            this.nYa.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
