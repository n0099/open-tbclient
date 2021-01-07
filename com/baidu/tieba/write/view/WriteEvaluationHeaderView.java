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
/* loaded from: classes8.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mSkinType;
    private EMTextView ocA;
    private EMTextView ocB;
    private ImageView ocC;
    private View ocD;
    private View ocE;
    private ItemCardView ocF;
    private RankStarView ocG;
    private b ocH;
    private a ocI;
    private boolean ocJ;

    /* loaded from: classes8.dex */
    public interface a {
        void ap(float f);
    }

    /* loaded from: classes8.dex */
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
        this.ocJ = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.ocB = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.ocA = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.ocD = findViewById(R.id.write_select_item_relevance);
        this.ocC = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.ocE = findViewById(R.id.item_relevance_line);
        this.ocF = (ItemCardView) findViewById(R.id.item_star_info);
        this.ocG = (RankStarView) findViewById(R.id.item_set_new_star);
        this.ocG.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.ocG.setClickable(true);
        this.ocG.setStarChangListener(this);
        this.ocF.bxu();
        this.ocF.setOnCloseListener(this);
        this.ocF.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.ocD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteEvaluationHeaderView.this.dZj();
            }
        });
    }

    public void dZj() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelevanceItemSearchActivityConfig(getContext(), RequestResponseCode.REQUEST_SDK_WEB_VIEW)));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.ocA != null) {
                ao.setViewTextColor(this.ocA, R.color.CAM_X0109);
                c.bv(this.ocA).pK(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.ocC != null) {
                SvgManager.bwr().a(this.ocC, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.ocE != null) {
                ao.setBackgroundColor(this.ocE, R.color.CAM_X0210);
            }
            if (this.ocF != null) {
                ao.setBackgroundColor(this.ocF, R.color.CAM_X0206);
            }
            if (this.ocB != null) {
                ao.setViewTextColor(this.ocB, R.color.CAM_X0105);
            }
            if (this.ocG != null) {
                this.ocG.onChangeSkinType(skinType);
            }
            if (this.ocG != null) {
                this.ocG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.ocJ) {
            this.ocF.setVisibility(0);
            this.ocE.setVisibility(8);
        }
        this.ocG.setVisibility(0);
        this.ocG.setStarCount(0.0f);
        this.ocA.setVisibility(8);
        this.ocF.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.ocG.getStarCount();
    }

    public void setStarCount(int i) {
        this.ocG.setStarCount(i);
    }

    public boolean dZk() {
        return this.ocG.bJE();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void ap(float f) {
        if (this.ocI != null) {
            this.ocI.ap(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.ocJ = z;
        this.ocF.setVisibility(8);
        this.ocE.setVisibility(0);
        this.ocD.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.ocH = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.ocI = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.ocF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ocF.setVisibility(8);
        this.ocE.setVisibility(0);
        this.ocG.setVisibility(8);
        this.ocA.setVisibility(0);
        if (this.ocH != null) {
            this.ocH.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
