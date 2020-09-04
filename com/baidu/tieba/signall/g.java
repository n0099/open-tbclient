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
import com.baidu.tbadk.core.util.ap;
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
    private c lWb;
    private boolean lWo;
    private SignAllForumActivity lWz;
    private ArrayList<d> hsy = new ArrayList<>();
    private HashMap<String, SignSingleModel> lWA = new HashMap<>();
    private boolean hIq = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.lWz = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.lWb = cVar;
            this.hsy = cVar.dtN();
            if (this.hsy.size() == 0) {
                this.hIq = false;
            } else {
                this.hIq = true;
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
        if (this.hIq) {
            return this.hsy.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hsy.size() > i) {
            return this.hsy.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Hx(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.lWz.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.lWG = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.lWG.setIsRound(false);
            bVar.lWG.setGifIconSupport(false);
            bVar.lWI = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.lWJ = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.lWK = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.lWL = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.lWM = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.lWN = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.lWO = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.lWP = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.lWQ = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.lWR = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.lWH = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.lWS = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.lWz.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.lWE = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.lWF = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.lWz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lWz.getLayoutMode().onModeChanged(view);
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
            bVar.lWI.setText(str);
            ap.setImageResource(bVar.lWJ, BitmapHelper.getSmallGradeResourceIdNew(dVar.dua()));
            bVar.lWK.setText(dVar.dub() + "/" + dVar.duc());
            bVar.lWS.clearAnimation();
            if (dVar.bGH()) {
                bVar.lWH.setVisibility(0);
                bVar.lWR.setVisibility(8);
                bVar.lWM.setVisibility(0);
                bVar.lWN.setVisibility(8);
                bVar.lWM.setText(String.format(this.lWz.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.dtZ())));
                if (dVar.dug()) {
                    bVar.lWK.setText(this.lWz.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.lWS.setVisibility(8);
                } else {
                    bVar.lWK.setText(dVar.dub() + "/" + dVar.duc());
                    bVar.lWS.setVisibility(0);
                }
                int duf = dVar.duf();
                if (duf > 0) {
                    bVar.lWS.setVisibility(0);
                    bVar.lWS.setText("+" + duf);
                } else {
                    bVar.lWS.setVisibility(8);
                }
            } else if (dVar.dud()) {
                bVar.lWH.setVisibility(0);
                bVar.lWR.setVisibility(8);
                bVar.lWS.setVisibility(8);
                bVar.lWM.setVisibility(8);
                bVar.lWN.setVisibility(0);
                if (dVar.due()) {
                    bVar.lWO.setVisibility(4);
                    bVar.lWP.setVisibility(0);
                    bVar.lWQ.setText(R.string.signallforum_resigning);
                } else {
                    bVar.lWO.setVisibility(0);
                    bVar.lWP.setVisibility(4);
                    bVar.lWQ.setText(R.string.signallforum_resign);
                }
                bVar.lWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.due()) {
                            bVar.lWO.setVisibility(4);
                            bVar.lWP.setVisibility(0);
                            bVar.lWQ.setText(R.string.signallforum_resigning);
                            dVar.vQ(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.lWz);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.lWA.put(str2, signSingleModel);
                            }
                            signSingleModel.fM(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.lWM.setVisibility(8);
                bVar.lWN.setVisibility(8);
                bVar.lWS.setVisibility(8);
                bVar.lWH.setVisibility(0);
                bVar.lWR.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.lWG.setTag(avatar);
            bVar.lWG.setPlaceHolder(1);
            bVar.lWG.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.hIq) {
            return ciK();
        }
        int itemViewType = getItemViewType(i);
        View Hx = view == null ? Hx(itemViewType) : view;
        if (itemViewType == 1) {
            if (Hx.getTag() != null && (Hx.getTag() instanceof a)) {
                view2 = Hx;
                aVar = (a) Hx.getTag();
            } else {
                View Hx2 = Hx(itemViewType);
                view2 = Hx2;
                aVar = (a) Hx2.getTag();
            }
            this.lWz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.lWz.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.lWE.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            j(aVar.lWF, i);
            return view2;
        }
        if (Hx.getTag() == null || !(Hx.getTag() instanceof b)) {
            Hx = Hx(itemViewType);
        }
        a(Hx, viewGroup, i);
        return Hx;
    }

    private void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.lWb == null ? 7 : this.lWb.getLevel();
        if (this.hsy == null || this.hsy.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.hsy.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.dua() >= level) {
                        if (next.bGH()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bGH()) {
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
            format = String.format(this.lWz.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.lWz.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View ciK() {
        View inflate = LayoutInflater.from(this.lWz.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.lWz.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.lWz.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.dE(null, this.lWz.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lWz.getLayoutMode().setNightMode(skinType == 1);
        this.lWz.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.lWz.getPageContext(), skinType);
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
        public BarImageView lWG;
        public LinearLayout lWH;
        public TextView lWI;
        public ImageView lWJ;
        public TextView lWK;
        public FrameLayout lWL;
        public TextView lWM;
        public RelativeLayout lWN;
        public ImageView lWO;
        public ProgressBar lWP;
        public TextView lWQ;
        public TextView lWR;
        public TextView lWS;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a {
        public TextView lWE;
        public TextView lWF;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.lWA.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void fL(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.lWz.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.lWA.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.hsy.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.hsy.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.vO(z);
                dVar.vP(!z);
                dVar.vQ(false);
                if (z) {
                    dVar.Hu(signData.count_sign_num);
                    dVar.Hw(signData.sign_bonus_point);
                    dVar.Ht(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> dtQ = this.lWb.dtQ();
                    if (dtQ.contains(dVar)) {
                        dtQ.remove(dVar);
                        this.lWb.dtP().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.lWo) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void dum() {
        this.lWo = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.lWA.entrySet()) {
                    entry.getValue().duF();
                }
                this.lWA.clear();
            }
        }
    }
}
