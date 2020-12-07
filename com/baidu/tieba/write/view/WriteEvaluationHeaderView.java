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
    private EMTextView oal;
    private EMTextView oam;
    private ImageView oan;
    private View oao;
    private View oap;
    private ItemCardView oaq;
    private RankStarView oar;
    private b oas;
    private a oat;
    private boolean oau;

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
        this.oau = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.oam = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.oal = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.oao = findViewById(R.id.write_select_item_relevance);
        this.oan = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.oap = findViewById(R.id.item_relevance_line);
        this.oaq = (ItemCardView) findViewById(R.id.item_star_info);
        this.oar = (RankStarView) findViewById(R.id.item_set_new_star);
        this.oar.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.oar.setClickable(true);
        this.oar.setStarChangListener(this);
        this.oaq.buY();
        this.oaq.setOnCloseListener(this);
        this.oaq.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.oao.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteEvaluationHeaderView.this.dZY();
            }
        });
    }

    public void dZY() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelevanceItemSearchActivityConfig(getContext(), RequestResponseCode.REQUEST_SDK_WEB_VIEW)));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.oal != null) {
                ap.setViewTextColor(this.oal, R.color.CAM_X0109);
                c.bm(this.oal).pA(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.oan != null) {
                SvgManager.btW().a(this.oan, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.oap != null) {
                ap.setBackgroundColor(this.oap, R.color.CAM_X0210);
            }
            if (this.oaq != null) {
                ap.setBackgroundColor(this.oaq, R.color.CAM_X0206);
            }
            if (this.oam != null) {
                ap.setViewTextColor(this.oam, R.color.CAM_X0105);
            }
            if (this.oar != null) {
                this.oar.onChangeSkinType(skinType);
            }
            if (this.oar != null) {
                this.oar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.oau) {
            this.oaq.setVisibility(0);
            this.oap.setVisibility(8);
        }
        this.oar.setVisibility(0);
        this.oar.setStarCount(0.0f);
        this.oal.setVisibility(8);
        this.oaq.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.oar.getStarCount();
    }

    public void setStarCount(int i) {
        this.oar.setStarCount(i);
    }

    public boolean dZZ() {
        return this.oar.bHk();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void an(float f) {
        if (this.oat != null) {
            this.oat.an(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.oau = z;
        this.oaq.setVisibility(8);
        this.oap.setVisibility(0);
        this.oao.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.oas = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.oat = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.oaq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.oaq.setVisibility(8);
        this.oap.setVisibility(0);
        this.oar.setVisibility(8);
        this.oal.setVisibility(0);
        if (this.oas != null) {
            this.oas.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
