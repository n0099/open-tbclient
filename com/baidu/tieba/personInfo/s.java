package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private List<MyGift> bKL;
    final /* synthetic */ r bKM;

    public s(r rVar, List<MyGift> list) {
        this.bKM = rVar;
        this.bKL = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bKL == null) {
            return 0;
        }
        if (this.bKL.size() <= 8) {
            return this.bKL.size();
        }
        return 8;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0077: INVOKE  (r0v5 int A[REMOVE]) = (r2v8 com.baidu.tbadk.data.MyGift) type: VIRTUAL call: com.baidu.tbadk.data.MyGift.getGiftNum():int)] */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        PersonInfoActivity personInfoActivity;
        PersonInfoActivity personInfoActivity2;
        PersonInfoActivity personInfoActivity3;
        com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
        personInfoActivity = this.bKM.bJZ;
        View inflate = ei.inflate(personInfoActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_gift_icon, null);
        personInfoActivity2 = this.bKM.bJZ;
        int dimensionPixelSize = personInfoActivity2.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds86);
        personInfoActivity3 = this.bKM.bJZ;
        inflate.setLayoutParams(new AbsListView.LayoutParams(dimensionPixelSize, personInfoActivity3.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds80)));
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.gift_icon);
        headImageView.setIsRound(true);
        headImageView.setDrawBorder(false);
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.setSupportNoImage(false);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.gift_num);
        g(textView);
        MyGift myGift = this.bKL.get(i);
        if (myGift != null) {
            headImageView.d(myGift.getGiftIcon(), 10, false);
            textView.setText(new StringBuilder().append(myGift.getGiftNum()).toString());
        }
        return inflate;
    }

    private void g(TextView textView) {
        bc.i((View) textView, com.baidu.tieba.v.personinfo_gift_num_bg);
        bc.b(textView, com.baidu.tieba.t.cp_cont_g, 1);
    }
}
