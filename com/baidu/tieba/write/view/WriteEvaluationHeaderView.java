package com.baidu.tieba.write.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
/* loaded from: classes3.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    private TbRichTextEvaluateItemInfo mEvaluateItemInfo;
    private int mSkinType;
    private EMTextView oan;
    private EMTextView oao;
    private ImageView oap;
    private View oaq;
    private View oar;
    private ItemCardView oas;
    private RankStarView oat;
    private b oau;
    private a oav;
    private boolean oaw;

    /* loaded from: classes3.dex */
    public interface a {
        void an(float f);
    }

    /* loaded from: classes3.dex */
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
        this.oaw = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.oao = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.oan = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.oaq = findViewById(R.id.write_select_item_relevance);
        this.oap = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.oar = findViewById(R.id.item_relevance_line);
        this.oas = (ItemCardView) findViewById(R.id.item_star_info);
        this.oat = (RankStarView) findViewById(R.id.item_set_new_star);
        this.oat.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.oat.setClickable(true);
        this.oat.setStarChangListener(this);
        this.oas.buY();
        this.oas.setOnCloseListener(this);
        this.oas.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.oaq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteEvaluationHeaderView.this.dZZ();
            }
        });
    }

    public void dZZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelevanceItemSearchActivityConfig(getContext(), RequestResponseCode.REQUEST_SDK_WEB_VIEW)));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.oan != null) {
                ap.setViewTextColor(this.oan, R.color.CAM_X0109);
                c.bm(this.oan).pA(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.oap != null) {
                SvgManager.btW().a(this.oap, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.oar != null) {
                ap.setBackgroundColor(this.oar, R.color.CAM_X0210);
            }
            if (this.oas != null) {
                ap.setBackgroundColor(this.oas, R.color.CAM_X0206);
            }
            if (this.oao != null) {
                ap.setViewTextColor(this.oao, R.color.CAM_X0105);
            }
            if (this.oat != null) {
                this.oat.onChangeSkinType(skinType);
            }
            if (this.oat != null) {
                this.oat.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.oaw) {
            this.oas.setVisibility(0);
            this.oar.setVisibility(8);
        }
        this.oat.setVisibility(0);
        this.oat.setStarCount(0.0f);
        this.oan.setVisibility(8);
        this.oas.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.oat.getStarCount();
    }

    public void setStarCount(int i) {
        this.oat.setStarCount(i);
    }

    public boolean eaa() {
        return this.oat.bHk();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void an(float f) {
        if (this.oav != null) {
            this.oav.an(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.oaw = z;
        this.oas.setVisibility(8);
        this.oar.setVisibility(0);
        this.oaq.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.oau = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.oav = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.oas;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.oas.setVisibility(8);
        this.oar.setVisibility(0);
        this.oat.setVisibility(8);
        this.oan.setVisibility(0);
        if (this.oau != null) {
            this.oau.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
