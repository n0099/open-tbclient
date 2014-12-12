package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private List<MyGift> bIZ;
    final /* synthetic */ r bJa;

    public s(r rVar, List<MyGift> list) {
        this.bJa = rVar;
        this.bIZ = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bIZ == null) {
            return 0;
        }
        if (this.bIZ.size() <= 8) {
            return this.bIZ.size();
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
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        personInfoActivity = this.bJa.bIn;
        View inflate = ek.inflate(personInfoActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_gift_icon, null);
        personInfoActivity2 = this.bJa.bIn;
        int dimensionPixelSize = personInfoActivity2.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds86);
        personInfoActivity3 = this.bJa.bIn;
        inflate.setLayoutParams(new AbsListView.LayoutParams(dimensionPixelSize, personInfoActivity3.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds80)));
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.gift_icon);
        headImageView.setIsRound(true);
        headImageView.setDrawBorder(false);
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.setSupportNoImage(false);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.gift_num);
        g(textView);
        MyGift myGift = this.bIZ.get(i);
        if (myGift != null) {
            headImageView.d(myGift.getGiftIcon(), 10, false);
            textView.setText(new StringBuilder().append(myGift.getGiftNum()).toString());
        }
        return inflate;
    }

    private void g(TextView textView) {
        ax.i((View) textView, com.baidu.tieba.v.personinfo_gift_num_bg);
        ax.b(textView, com.baidu.tieba.t.cp_cont_g, 1);
    }
}
