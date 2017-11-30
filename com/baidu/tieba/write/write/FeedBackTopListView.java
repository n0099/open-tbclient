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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FeedBackTopListView extends LinearLayout {
    private ArrayList<bd> hhv;
    private Context mContext;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.hhv = null;
        this.mSkinType = 3;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<bd> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.mPageContext = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.hhv = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.hhv = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.hhv.size()) {
                addView(d(this.hhv.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View d(final bd bdVar, int i) {
        if (bdVar == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.g.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(d.g.frs_top_title);
        inflate.findViewById(d.g.frs_top_divider);
        final String tid = bdVar.getTid();
        textView.setText(bdVar.getTitle());
        this.mPageContext.getLayoutMode().ag(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().t(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) aj.getDrawable(d.f.icon_notice);
        aj.j(linearLayout, d.f.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FeedBackTopListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bdVar.getThreadType() != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FeedBackTopListView.this.mContext).createNormalCfg(tid, null, WriteActivityConfig.FEED_BACK)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(FeedBackTopListView.this.mContext, bdVar.getTid()).cx(bdVar.rO()).pp()));
            }
        });
        return inflate;
    }
}
