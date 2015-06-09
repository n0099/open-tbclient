package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private List<MyGift> bVS;
    final /* synthetic */ r bVT;

    public s(r rVar, List<MyGift> list) {
        this.bVT = rVar;
        this.bVS = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bVS == null) {
            return 0;
        }
        if (this.bVS.size() <= 8) {
            return this.bVS.size();
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0074: INVOKE  (r0v5 int A[REMOVE]) = (r2v8 com.baidu.tbadk.data.MyGift) type: VIRTUAL call: com.baidu.tbadk.data.MyGift.getGiftNum():int)] */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        PersonInfoActivity personInfoActivity;
        PersonInfoActivity personInfoActivity2;
        PersonInfoActivity personInfoActivity3;
        com.baidu.adp.lib.g.b hr = com.baidu.adp.lib.g.b.hr();
        personInfoActivity = this.bVT.bVg;
        View inflate = hr.inflate(personInfoActivity.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_gift_icon, null);
        personInfoActivity2 = this.bVT.bVg;
        int dimensionPixelSize = personInfoActivity2.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds86);
        personInfoActivity3 = this.bVT.bVg;
        inflate.setLayoutParams(new AbsListView.LayoutParams(dimensionPixelSize, personInfoActivity3.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds80)));
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(com.baidu.tieba.q.gift_icon);
        headImageView.setIsRound(true);
        headImageView.setDrawBorder(false);
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.gift_num);
        f(textView);
        MyGift myGift = this.bVS.get(i);
        if (myGift != null) {
            headImageView.c(myGift.getGiftIcon(), 10, false);
            textView.setText(new StringBuilder().append(myGift.getGiftNum()).toString());
        }
        return inflate;
    }

    private void f(TextView textView) {
        ay.i((View) textView, com.baidu.tieba.p.personinfo_gift_num_bg);
        ay.b(textView, com.baidu.tieba.n.cp_cont_g, 1);
    }
}
