package com.baidu.tieba.personInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.MyGift;
import java.util.List;
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private List<MyGift> bFE;
    final /* synthetic */ r bFF;

    public s(r rVar, List<MyGift> list) {
        this.bFF = rVar;
        this.bFE = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bFE == null) {
            return 0;
        }
        if (this.bFE.size() <= 8) {
            return this.bFE.size();
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x006f: INVOKE  (r0v5 int A[REMOVE]) = (r2v8 com.baidu.tbadk.data.MyGift) type: VIRTUAL call: com.baidu.tbadk.data.MyGift.getGiftNum():int)] */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        PersonInfoActivity personInfoActivity;
        PersonInfoActivity personInfoActivity2;
        PersonInfoActivity personInfoActivity3;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        personInfoActivity = this.bFF.bES;
        View inflate = ek.inflate(personInfoActivity, com.baidu.tieba.w.personinfo_gift_icon, null);
        personInfoActivity2 = this.bFF.bES;
        int dimensionPixelSize = personInfoActivity2.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds86);
        personInfoActivity3 = this.bFF.bES;
        inflate.setLayoutParams(new AbsListView.LayoutParams(dimensionPixelSize, personInfoActivity3.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds80)));
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.gift_icon);
        headImageView.setIsRound(true);
        headImageView.setDrawBorder(false);
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.setSupportNoImage(false);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.gift_num);
        h(textView);
        MyGift myGift = this.bFE.get(i);
        if (myGift != null) {
            headImageView.c(myGift.getGiftIcon(), 10, false);
            textView.setText(new StringBuilder().append(myGift.getGiftNum()).toString());
        }
        return inflate;
    }

    private void h(TextView textView) {
        aw.h((View) textView, com.baidu.tieba.u.personinfo_gift_num_bg);
        aw.b(textView, com.baidu.tieba.s.cp_cont_g, 1);
    }
}
