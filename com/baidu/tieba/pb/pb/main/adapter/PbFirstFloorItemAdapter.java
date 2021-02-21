package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.i;
import com.baidu.tieba.tbadkCore.data.m;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class PbFirstFloorItemAdapter extends com.baidu.adp.widget.ListView.a<i, PbFirstFloorItemViewHolder> {
    public PbFirstFloorItemAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cF */
    public PbFirstFloorItemViewHolder e(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int dimens = l.getDimens(this.mContext, R.dimen.M_W_X007);
        int dimens2 = l.getDimens(this.mContext, R.dimen.T_X09);
        int dimens3 = l.getDimens(this.mContext, R.dimen.M_H_X005);
        int dimens4 = l.getDimens(this.mContext, R.dimen.M_H_X003);
        View view = new View(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(this.mContext, R.dimen.tbds1));
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = dimens;
        linearLayout.addView(view, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, dimens2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = dimens;
        layoutParams2.topMargin = dimens3;
        layoutParams2.bottomMargin = dimens4;
        linearLayout.addView(textView, layoutParams2);
        ItemCardView itemCardView = new ItemCardView(this.mContext);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = dimens;
        layoutParams3.rightMargin = dimens;
        layoutParams3.bottomMargin = dimens3;
        linearLayout.addView(itemCardView, layoutParams3);
        a(new w() { // from class: com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view2, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (nVar instanceof i) {
                    i iVar = (i) nVar;
                    if (iVar.item != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("itemID", String.valueOf(iVar.item.item_id));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                        ar arVar = new ar("c14071");
                        arVar.dR("tid", iVar.tid);
                        arVar.v("obj_locate", iVar.item.item_id.longValue());
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        return new PbFirstFloorItemViewHolder(linearLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        if (iVar != null && iVar.item != null) {
            pbFirstFloorItemViewHolder.a(iVar);
        }
        pbFirstFloorItemViewHolder.onChangeSkinType();
        ar arVar = new ar("c14070");
        arVar.dR("tid", iVar.tid);
        arVar.v("obj_locate", iVar.item.item_id.longValue());
        TiebaStatic.log(arVar);
        return view;
    }

    /* loaded from: classes2.dex */
    public class PbFirstFloorItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        private View bTo;
        private ItemCardView mbW;
        private TextView textView;

        public PbFirstFloorItemViewHolder(View view) {
            super(view);
            this.bTo = ((ViewGroup) view).getChildAt(0);
            this.textView = (TextView) ((ViewGroup) view).getChildAt(1);
            this.mbW = (ItemCardView) ((ViewGroup) view).getChildAt(2);
        }

        public void a(i iVar) {
            if (iVar != null) {
                this.textView.setText(PbFirstFloorItemAdapter.this.mContext.getText(R.string.related_recommendation));
                this.mbW.setData(iVar.item, 17);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        public void onChangeSkinType() {
            ap.setBackgroundColor(this.bTo, R.color.CAM_X0203);
            ap.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.mbW.onChangeSkinType();
        }
    }
}
