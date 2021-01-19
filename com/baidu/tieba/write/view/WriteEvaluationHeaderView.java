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
    private EMTextView nXU;
    private EMTextView nXV;
    private ImageView nXW;
    private View nXX;
    private View nXY;
    private ItemCardView nXZ;
    private RankStarView nYa;
    private b nYb;
    private a nYc;
    private boolean nYd;

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
        this.nYd = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.nXV = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.nXU = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.nXX = findViewById(R.id.write_select_item_relevance);
        this.nXW = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.nXY = findViewById(R.id.item_relevance_line);
        this.nXZ = (ItemCardView) findViewById(R.id.item_star_info);
        this.nYa = (RankStarView) findViewById(R.id.item_set_new_star);
        this.nYa.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.nYa.setClickable(true);
        this.nYa.setStarChangListener(this);
        this.nXZ.btA();
        this.nXZ.setOnCloseListener(this);
        this.nXZ.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.nXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
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
            if (this.nXU != null) {
                ao.setViewTextColor(this.nXU, R.color.CAM_X0109);
                c.bv(this.nXU).od(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.nXW != null) {
                SvgManager.bsx().a(this.nXW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.nXY != null) {
                ao.setBackgroundColor(this.nXY, R.color.CAM_X0210);
            }
            if (this.nXZ != null) {
                ao.setBackgroundColor(this.nXZ, R.color.CAM_X0206);
            }
            if (this.nXV != null) {
                ao.setViewTextColor(this.nXV, R.color.CAM_X0105);
            }
            if (this.nYa != null) {
                this.nYa.onChangeSkinType(skinType);
            }
            if (this.nYa != null) {
                this.nYa.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.nYd) {
            this.nXZ.setVisibility(0);
            this.nXY.setVisibility(8);
        }
        this.nYa.setVisibility(0);
        this.nYa.setStarCount(0.0f);
        this.nXU.setVisibility(8);
        this.nXZ.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.nYa.getStarCount();
    }

    public void setStarCount(int i) {
        this.nYa.setStarCount(i);
    }

    public boolean dVs() {
        return this.nYa.bFM();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void ap(float f) {
        if (this.nYc != null) {
            this.nYc.ap(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.nYd = z;
        this.nXZ.setVisibility(8);
        this.nXY.setVisibility(0);
        this.nXX.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.nYb = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.nYc = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.nXZ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.nXZ.setVisibility(8);
        this.nXY.setVisibility(0);
        this.nYa.setVisibility(8);
        this.nXU.setVisibility(0);
        if (this.nYb != null) {
            this.nYb.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
