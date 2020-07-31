package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes18.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private SignAllForumActivity lED;
    private c lEg;
    private ArrayList<d> hfz = new ArrayList<>();
    private HashMap<String, SignSingleModel> lEE = new HashMap<>();
    private boolean huV = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.lED = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.lEg = cVar;
            this.hfz = cVar.din();
            if (this.hfz.size() == 0) {
                this.huV = false;
            } else {
                this.huV = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof com.baidu.tieba.signall.b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.huV) {
            return this.hfz.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hfz.size() > i) {
            return this.hfz.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Fa(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.lED.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.lEK = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.lEK.setIsRound(false);
            bVar.lEK.setGifIconSupport(false);
            bVar.lEM = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.lEN = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.lEO = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.lEP = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.lEQ = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.lER = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.lES = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.lET = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.lEU = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.lEV = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.lEL = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.lEW = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.lED.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.lEI = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.lEJ = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.lED.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lED.getLayoutMode().onModeChanged(view);
        final b bVar = (b) view.getTag();
        final d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = forumName.substring(0, i3) + StringHelper.STRING_MORE;
                        break;
                    }
                }
            }
            str = forumName;
            bVar.lEM.setText(str);
            ao.setImageResource(bVar.lEN, BitmapHelper.getSmallGradeResourceIdNew(dVar.diA()));
            bVar.lEO.setText(dVar.diB() + "/" + dVar.diC());
            bVar.lEW.clearAnimation();
            if (dVar.bxH()) {
                bVar.lEL.setVisibility(0);
                bVar.lEV.setVisibility(8);
                bVar.lEQ.setVisibility(0);
                bVar.lER.setVisibility(8);
                bVar.lEQ.setText(String.format(this.lED.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.diz())));
                if (dVar.diG()) {
                    bVar.lEO.setText(this.lED.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.lEW.setVisibility(8);
                } else {
                    bVar.lEO.setText(dVar.diB() + "/" + dVar.diC());
                    bVar.lEW.setVisibility(0);
                }
                int diF = dVar.diF();
                if (diF > 0) {
                    bVar.lEW.setVisibility(0);
                    bVar.lEW.setText("+" + diF);
                } else {
                    bVar.lEW.setVisibility(8);
                }
            } else if (dVar.diD()) {
                bVar.lEL.setVisibility(0);
                bVar.lEV.setVisibility(8);
                bVar.lEW.setVisibility(8);
                bVar.lEQ.setVisibility(8);
                bVar.lER.setVisibility(0);
                if (dVar.diE()) {
                    bVar.lES.setVisibility(4);
                    bVar.lET.setVisibility(0);
                    bVar.lEU.setText(R.string.signallforum_resigning);
                } else {
                    bVar.lES.setVisibility(0);
                    bVar.lET.setVisibility(4);
                    bVar.lEU.setText(R.string.signallforum_resign);
                }
                bVar.lER.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.diE()) {
                            bVar.lES.setVisibility(4);
                            bVar.lET.setVisibility(0);
                            bVar.lEU.setText(R.string.signallforum_resigning);
                            dVar.uZ(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.lED);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.lEE.put(str2, signSingleModel);
                            }
                            signSingleModel.fu(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.lEQ.setVisibility(8);
                bVar.lER.setVisibility(8);
                bVar.lEW.setVisibility(8);
                bVar.lEL.setVisibility(0);
                bVar.lEV.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.lEK.setTag(avatar);
            bVar.lEK.setPlaceHolder(1);
            bVar.lEK.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.huV) {
            return bYn();
        }
        int itemViewType = getItemViewType(i);
        View Fa = view == null ? Fa(itemViewType) : view;
        if (itemViewType == 1) {
            if (Fa.getTag() != null && (Fa.getTag() instanceof a)) {
                view2 = Fa;
                aVar = (a) Fa.getTag();
            } else {
                View Fa2 = Fa(itemViewType);
                view2 = Fa2;
                aVar = (a) Fa2.getTag();
            }
            this.lED.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.lED.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.lEI.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.lEJ, i);
            return view2;
        }
        if (Fa.getTag() == null || !(Fa.getTag() instanceof b)) {
            Fa = Fa(itemViewType);
        }
        a(Fa, viewGroup, i);
        return Fa;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.lEg == null ? 7 : this.lEg.getLevel();
        if (this.hfz == null || this.hfz.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.hfz.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.diA() >= level) {
                        if (next.bxH()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bxH()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i5 = i5;
                    i4 = i4;
                    i3 = i3;
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.lED.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.lED.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bYn() {
        View inflate = LayoutInflater.from(this.lED.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.lED.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.lED.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.m31do(null, this.lED.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lED.getLayoutMode().setNightMode(skinType == 1);
        this.lED.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.lED.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b {
        public BarImageView lEK;
        public LinearLayout lEL;
        public TextView lEM;
        public ImageView lEN;
        public TextView lEO;
        public FrameLayout lEP;
        public TextView lEQ;
        public RelativeLayout lER;
        public ImageView lES;
        public ProgressBar lET;
        public TextView lEU;
        public TextView lEV;
        public TextView lEW;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a {
        public TextView lEI;
        public TextView lEJ;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.lEE.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ft(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.lED.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.lEE.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.hfz.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.hfz.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.uX(z);
                dVar.uY(!z);
                dVar.uZ(false);
                if (z) {
                    dVar.EX(signData.count_sign_num);
                    dVar.EZ(signData.sign_bonus_point);
                    dVar.EW(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> diq = this.lEg.diq();
                    if (diq.contains(dVar)) {
                        diq.remove(dVar);
                        this.lEg.dip().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.isDestory) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void diM() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.lEE.entrySet()) {
                    entry.getValue().djf();
                }
                this.lEE.clear();
            }
        }
    }
}
