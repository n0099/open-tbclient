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
/* loaded from: classes7.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mSkinType;
    private EMTextView okF;
    private EMTextView okG;
    private ImageView okH;
    private View okI;
    private View okJ;
    private ItemCardView okK;
    private RankStarView okL;
    private b okM;
    private a okN;
    private boolean okO;

    /* loaded from: classes7.dex */
    public interface a {
        void au(float f);
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
        this.okO = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.okG = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.okF = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.okI = findViewById(R.id.write_select_item_relevance);
        this.okH = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.okJ = findViewById(R.id.item_relevance_line);
        this.okK = (ItemCardView) findViewById(R.id.item_star_info);
        this.okL = (RankStarView) findViewById(R.id.item_set_new_star);
        this.okL.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.okL.setClickable(true);
        this.okL.setStarChangListener(this);
        this.okK.btX();
        this.okK.setOnCloseListener(this);
        this.okK.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.okI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteEvaluationHeaderView.this.dXV();
            }
        });
    }

    public void dXV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelevanceItemSearchActivityConfig(getContext(), RequestResponseCode.REQUEST_SDK_WEB_VIEW)));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.okF != null) {
                ap.setViewTextColor(this.okF, R.color.CAM_X0109);
                c.br(this.okF).oh(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.okH != null) {
                SvgManager.bsU().a(this.okH, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.okJ != null) {
                ap.setBackgroundColor(this.okJ, R.color.CAM_X0210);
            }
            if (this.okK != null) {
                ap.setBackgroundColor(this.okK, R.color.CAM_X0206);
            }
            if (this.okG != null) {
                ap.setViewTextColor(this.okG, R.color.CAM_X0105);
            }
            if (this.okL != null) {
                this.okL.onChangeSkinType(skinType);
            }
            if (this.okL != null) {
                this.okL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.okO) {
            this.okK.setVisibility(0);
            this.okJ.setVisibility(8);
        }
        this.okL.setVisibility(0);
        this.okL.setStarCount(0.0f);
        this.okF.setVisibility(8);
        this.okK.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.okL.getStarCount();
    }

    public void setStarCount(int i) {
        this.okL.setStarCount(i);
    }

    public boolean dXW() {
        return this.okL.bGk();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void au(float f) {
        if (this.okN != null) {
            this.okN.au(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.okO = z;
        this.okK.setVisibility(8);
        this.okJ.setVisibility(0);
        this.okI.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.okM = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.okN = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.okK;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.okK.setVisibility(8);
        this.okJ.setVisibility(0);
        this.okL.setVisibility(8);
        this.okF.setVisibility(0);
        if (this.okM != null) {
            this.okM.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
