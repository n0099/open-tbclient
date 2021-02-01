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
    private EMTextView oia;
    private EMTextView oib;
    private ImageView oic;
    private View oid;
    private View oie;
    private ItemCardView oif;
    private RankStarView oig;
    private b oih;
    private a oii;
    private boolean oij;

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
        this.oij = true;
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
        this.oib = (EMTextView) findViewById(R.id.item_relevance_desc);
        this.oia = (EMTextView) findViewById(R.id.item_relevance_tip);
        this.oid = findViewById(R.id.write_select_item_relevance);
        this.oic = (ImageView) findViewById(R.id.item_relevance_arrow);
        this.oie = findViewById(R.id.item_relevance_line);
        this.oif = (ItemCardView) findViewById(R.id.item_star_info);
        this.oig = (RankStarView) findViewById(R.id.item_set_new_star);
        this.oig.setStarSpacing(l.getDimens(getContext(), R.dimen.tbds30));
        this.oig.setClickable(true);
        this.oig.setStarChangListener(this);
        this.oif.btU();
        this.oif.setOnCloseListener(this);
        this.oif.setSizeStyle(1);
        initListener();
    }

    private void initListener() {
        this.oid.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.view.WriteEvaluationHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteEvaluationHeaderView.this.dXF();
            }
        });
    }

    public void dXF() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RelevanceItemSearchActivityConfig(getContext(), RequestResponseCode.REQUEST_SDK_WEB_VIEW)));
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.oia != null) {
                ap.setViewTextColor(this.oia, R.color.CAM_X0109);
                c.br(this.oia).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            }
            if (this.oic != null) {
                SvgManager.bsR().a(this.oic, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (this.oie != null) {
                ap.setBackgroundColor(this.oie, R.color.CAM_X0210);
            }
            if (this.oif != null) {
                ap.setBackgroundColor(this.oif, R.color.CAM_X0206);
            }
            if (this.oib != null) {
                ap.setViewTextColor(this.oib, R.color.CAM_X0105);
            }
            if (this.oig != null) {
                this.oig.onChangeSkinType(skinType);
            }
            if (this.oig != null) {
                this.oig.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        this.mEvaluateItemInfo = tbRichTextEvaluateItemInfo;
        if (this.oij) {
            this.oif.setVisibility(0);
            this.oie.setVisibility(8);
        }
        this.oig.setVisibility(0);
        this.oig.setStarCount(0.0f);
        this.oia.setVisibility(8);
        this.oif.setData(tbRichTextEvaluateItemInfo, 10);
    }

    public int getStarCount() {
        return this.oig.getStarCount();
    }

    public void setStarCount(int i) {
        this.oig.setStarCount(i);
    }

    public boolean dXG() {
        return this.oig.bGg();
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void aq(float f) {
        if (this.oii != null) {
            this.oii.aq(f);
        }
    }

    public void setShowItemInfo(boolean z) {
        this.oij = z;
        this.oif.setVisibility(8);
        this.oie.setVisibility(0);
        this.oid.setVisibility(8);
    }

    public void setItemCloseListener(b bVar) {
        this.oih = bVar;
    }

    public void setStarChangeListener(a aVar) {
        this.oii = aVar;
    }

    public ItemCardView getItemStarInfo() {
        return this.oif;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.oif.setVisibility(8);
        this.oie.setVisibility(0);
        this.oig.setVisibility(8);
        this.oia.setVisibility(0);
        if (this.oih != null) {
            this.oih.onClose();
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        return this.mEvaluateItemInfo;
    }
}
