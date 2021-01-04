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
    private EMTextView ocB;
    private EMTextView ocC;
    private ImageView ocD;
    private View ocE;
    private View ocF;
    private ItemCardView ocG;
    private RankStarView ocH;
    private b ocI;
    private a ocJ;
    private boolean ocK;

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
        this.ocK = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.ocC = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.ocB = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.ocE = findViewById(R.id.write_select_item_relevance);
        this.ocD = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.ocF = findViewById(R.id.item_relevance_line);
        this.ocG = (ItemCardView) findViewById(R.id.item_star_info);
        this.ocH = (RankStarView) findViewById(R.id.item_set_new_star);
        this.ocH.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.ocH.setClickable(true);
        this.ocH.setStarChangListener(this);
        this.ocG.bxt();
        this.ocG.setOnCloseListener(this);
        this.ocG.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.ocE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteEvaluationHeaderView.this.dZi();
            }
        });
    }

    public void dZi() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelevanceItemSearchActivityConfig(getContext(), RequestResponseCode.REQUEST_SDK_WEB_VIEW)));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.ocB != null) {
                ao.setViewTextColor(this.ocB, R.color.CAM_X0109);
                c.bv(this.ocB).pK(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.ocD != null) {
                SvgManager.bwq().a(this.ocD, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.ocF != null) {
                ao.setBackgroundColor(this.ocF, R.color.CAM_X0210);
            }
            if (this.ocG != null) {
                ao.setBackgroundColor(this.ocG, R.color.CAM_X0206);
            }
            if (this.ocC != null) {
                ao.setViewTextColor(this.ocC, R.color.CAM_X0105);
            }
            if (this.ocH != null) {
                this.ocH.onChangeSkinType(skinType);
            }
            if (this.ocH != null) {
                this.ocH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.ocK) {
            this.ocG.setVisibility(0);
            this.ocF.setVisibility(8);
        }
        this.ocH.setVisibility(0);
        this.ocH.setStarCount(0.0f);
        this.ocB.setVisibility(8);
        this.ocG.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.ocH.getStarCount();
    }

    public void setStarCount(int i) {
        this.ocH.setStarCount(i);
    }

    public boolean dZj() {
        return this.ocH.bJD();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void ap(float f) {
        if (this.ocJ != null) {
            this.ocJ.ap(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.ocK = z;
        this.ocG.setVisibility(8);
        this.ocF.setVisibility(0);
        this.ocE.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.ocI = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.ocJ = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.ocG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ocG.setVisibility(8);
        this.ocF.setVisibility(0);
        this.ocH.setVisibility(8);
        this.ocB.setVisibility(0);
        if (this.ocI != null) {
            this.ocI.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
