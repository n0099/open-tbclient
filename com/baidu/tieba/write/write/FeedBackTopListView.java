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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FeedBackTopListView extends LinearLayout {
    private ArrayList<bl> gHg;
    private Context mContext;
    private int mSkinType;
    private TbPageContext<?> oW;

    public FeedBackTopListView(Context context) {
        this(context, null);
    }

    public FeedBackTopListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.gHg = null;
        this.mSkinType = 3;
        this.mContext = context;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<bl> arrayList, TbPageContext<?> tbPageContext) {
        int i = 0;
        this.oW = tbPageContext;
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (arrayList.size() > 3) {
            this.gHg = new ArrayList<>(arrayList.subList(0, 3));
        } else {
            this.gHg = arrayList;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.gHg.size()) {
                addView(d(this.gHg.get(i2), i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private View d(final bl blVar, int i) {
        if (blVar == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_top_item, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.h.frs_top_item);
        TextView textView = (TextView) inflate.findViewById(d.h.frs_top_title);
        inflate.findViewById(d.h.frs_top_divider);
        final String tid = blVar.getTid();
        textView.setText(blVar.getTitle());
        this.oW.getLayoutMode().ah(this.mSkinType == 1);
        this.oW.getLayoutMode().t(inflate);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) ai.getDrawable(d.g.icon_notice);
        ai.j(linearLayout, d.g.bg_frs_top_middle_selector);
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.FeedBackTopListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (blVar.getThreadType() != 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FeedBackTopListView.this.mContext).createNormalCfg(tid, null, WriteActivityConfig.FEED_BACK)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(FeedBackTopListView.this.mContext, blVar.getTid()).cC(blVar.rW()).po()));
            }
        });
        return inflate;
    }
}
