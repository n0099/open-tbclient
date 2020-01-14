package com.baidu.tieba.write.write;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class FeedBackTopListView extends LinearLayout {
    private ArrayList<bj> kRb;
    private Context mContext;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.kRb = null;
        this.mSkinType = 3;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<bj> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.mPageContext = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.kRb = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.kRb = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.kRb.size()) {
                addView(f(this.kRb.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View f(bj bjVar, int i) {
        if (bjVar == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(R.id.frs_top_title);
        inflate.findViewById(R.id.frs_top_divider);
        final String tid = bjVar.getTid();
        textView.setText(bjVar.getTitle());
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(R.drawable.icon_notice);
        am.setBackgroundResource(linearLayout, R.drawable.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FeedBackTopListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FeedBackTopListView.this.mContext).createNormalCfg(tid, null, WriteActivityConfig.FEED_BACK)));
            }
        });
        return inflate;
    }
}
