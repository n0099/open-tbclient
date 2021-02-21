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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mSkinType;
    private EMTextView oiA;
    private EMTextView oiB;
    private ImageView oiC;
    private View oiD;
    private View oiE;
    private ItemCardView oiF;
    private RankStarView oiG;
    private b oiH;
    private a oiI;
    private boolean oiJ;

    /* loaded from: classes8.dex */
    public interface a {
        void aq(float f);
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
        this.oiJ = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.oiB = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.oiA = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.oiD = findViewById(R.id.write_select_item_relevance);
        this.oiC = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.oiE = findViewById(R.id.item_relevance_line);
        this.oiF = (ItemCardView) findViewById(R.id.item_star_info);
        this.oiG = (RankStarView) findViewById(R.id.item_set_new_star);
        this.oiG.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.oiG.setClickable(true);
        this.oiG.setStarChangListener(this);
        this.oiF.btU();
        this.oiF.setOnCloseListener(this);
        this.oiF.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.oiD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteEvaluationHeaderView.this.dXN();
            }
        });
    }

    public void dXN() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelevanceItemSearchActivityConfig(getContext(), RequestResponseCode.REQUEST_SDK_WEB_VIEW)));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.oiA != null) {
                ap.setViewTextColor(this.oiA, R.color.CAM_X0109);
                c.br(this.oiA).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.oiC != null) {
                SvgManager.bsR().a(this.oiC, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.oiE != null) {
                ap.setBackgroundColor(this.oiE, R.color.CAM_X0210);
            }
            if (this.oiF != null) {
                ap.setBackgroundColor(this.oiF, R.color.CAM_X0206);
            }
            if (this.oiB != null) {
                ap.setViewTextColor(this.oiB, R.color.CAM_X0105);
            }
            if (this.oiG != null) {
                this.oiG.onChangeSkinType(skinType);
            }
            if (this.oiG != null) {
                this.oiG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.oiJ) {
            this.oiF.setVisibility(0);
            this.oiE.setVisibility(8);
        }
        this.oiG.setVisibility(0);
        this.oiG.setStarCount(0.0f);
        this.oiA.setVisibility(8);
        this.oiF.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.oiG.getStarCount();
    }

    public void setStarCount(int i) {
        this.oiG.setStarCount(i);
    }

    public boolean dXO() {
        return this.oiG.bGg();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void aq(float f) {
        if (this.oiI != null) {
            this.oiI.aq(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.oiJ = z;
        this.oiF.setVisibility(8);
        this.oiE.setVisibility(0);
        this.oiD.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.oiH = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.oiI = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.oiF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.oiF.setVisibility(8);
        this.oiE.setVisibility(0);
        this.oiG.setVisibility(8);
        this.oiA.setVisibility(0);
        if (this.oiH != null) {
            this.oiH.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
