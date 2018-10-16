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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c gTD;
    private SignAllForumActivity gTX;
    private boolean isDestory;
    private ArrayList<d> deX = new ArrayList<>();
    private HashMap<String, SignSingleModel> gTY = new HashMap<>();
    private boolean dmF = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gTX = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gTD = cVar;
            this.deX = cVar.byi();
            if (this.deX.size() == 0) {
                this.dmF = false;
            } else {
                this.dmF = true;
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
        if (this.dmF) {
            return this.deX.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.deX.size() > i) {
            return this.deX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View uj(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gTX.getPageContext().getPageActivity()).inflate(e.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gUe = (BarImageView) inflate.findViewById(e.g.signallforum_item_avatar);
            bVar.gUe.setIsRound(false);
            bVar.gUe.setGifIconSupport(false);
            bVar.gUg = (TextView) inflate.findViewById(e.g.signallforum_item_name);
            bVar.gUh = (ImageView) inflate.findViewById(e.g.signallforum_item_level);
            bVar.gUi = (TextView) inflate.findViewById(e.g.signallforum_item_exp);
            bVar.gUj = (FrameLayout) inflate.findViewById(e.g.signallforum_item_res_container);
            bVar.gUk = (TextView) inflate.findViewById(e.g.signallforum_item_days);
            bVar.gUl = (RelativeLayout) inflate.findViewById(e.g.signallforum_item_resign_container);
            bVar.gUm = (ImageView) inflate.findViewById(e.g.signallforum_item_resign_icon);
            bVar.gUn = (ProgressBar) inflate.findViewById(e.g.signallforum_item_resign_progress);
            bVar.gUo = (TextView) inflate.findViewById(e.g.signallforum_item_resign_text);
            bVar.gUp = (TextView) inflate.findViewById(e.g.signallforum_item_error);
            bVar.gUf = (LinearLayout) inflate.findViewById(e.g.signallforum_item_level_container);
            bVar.gUq = (TextView) inflate.findViewById(e.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gTX.getPageContext().getPageActivity()).inflate(e.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gUc = (TextView) inflate2.findViewById(e.g.signallforum_head_title);
        aVar.gUd = (TextView) inflate2.findViewById(e.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.gTX.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gTX.getLayoutMode().onModeChanged(view);
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
                        str = forumName.substring(0, i3) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            bVar.gUg.setText(str);
            al.c(bVar.gUh, BitmapHelper.getSmallGradeResourceIdNew(dVar.byv()));
            bVar.gUi.setText(dVar.byw() + "/" + dVar.byx());
            bVar.gUq.clearAnimation();
            if (dVar.Zu()) {
                bVar.gUf.setVisibility(0);
                bVar.gUp.setVisibility(8);
                bVar.gUk.setVisibility(0);
                bVar.gUl.setVisibility(8);
                bVar.gUk.setText(String.format(this.gTX.getPageContext().getString(e.j.signallforum_days), Integer.valueOf(dVar.byu())));
                if (dVar.byB()) {
                    bVar.gUi.setText(this.gTX.getPageContext().getString(e.j.signallforum_uplevel));
                    bVar.gUq.setVisibility(8);
                } else {
                    bVar.gUi.setText(dVar.byw() + "/" + dVar.byx());
                    bVar.gUq.setVisibility(0);
                }
                int byA = dVar.byA();
                if (byA > 0) {
                    bVar.gUq.setVisibility(0);
                    bVar.gUq.setText("+" + byA);
                } else {
                    bVar.gUq.setVisibility(8);
                }
            } else if (dVar.byy()) {
                bVar.gUf.setVisibility(0);
                bVar.gUp.setVisibility(8);
                bVar.gUq.setVisibility(8);
                bVar.gUk.setVisibility(8);
                bVar.gUl.setVisibility(0);
                if (dVar.byz()) {
                    bVar.gUm.setVisibility(4);
                    bVar.gUn.setVisibility(0);
                    bVar.gUo.setText(e.j.signallforum_resigning);
                } else {
                    bVar.gUm.setVisibility(0);
                    bVar.gUn.setVisibility(4);
                    bVar.gUo.setText(e.j.signallforum_resign);
                }
                bVar.gUl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.byz()) {
                            bVar.gUm.setVisibility(4);
                            bVar.gUn.setVisibility(0);
                            bVar.gUo.setText(e.j.signallforum_resigning);
                            dVar.mU(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gTX);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gTY.put(str2, signSingleModel);
                            }
                            signSingleModel.cB(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gUk.setVisibility(8);
                bVar.gUl.setVisibility(8);
                bVar.gUq.setVisibility(8);
                bVar.gUf.setVisibility(0);
                bVar.gUp.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gUe.setTag(avatar);
            bVar.gUe.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.dmF) {
            return avP();
        }
        int itemViewType = getItemViewType(i);
        View uj = view == null ? uj(itemViewType) : view;
        if (itemViewType == 1) {
            if (uj.getTag() != null && (uj.getTag() instanceof a)) {
                view2 = uj;
                aVar = (a) uj.getTag();
            } else {
                View uj2 = uj(itemViewType);
                view2 = uj2;
                aVar = (a) uj2.getTag();
            }
            this.gTX.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gTX.getLayoutMode().onModeChanged(view2.findViewById(e.g.sign_all_forum_tip));
            aVar.gUc.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gUd, i);
            return view2;
        }
        if (uj.getTag() == null || !(uj.getTag() instanceof b)) {
            uj = uj(itemViewType);
        }
        a(uj, viewGroup, i);
        return uj;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gTD == null ? 7 : this.gTD.getLevel();
        if (this.deX == null || this.deX.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.deX.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.byv() >= level) {
                        if (next.Zu()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.Zu()) {
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
            format = String.format(this.gTX.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gTX.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View avP() {
        View inflate = LayoutInflater.from(this.gTX.getPageContext().getPageActivity()).inflate(e.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gTX.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(e.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.G(e.j.sign_all_forum_nodata_tip, e.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gTX.getLayoutMode().setNightMode(skinType == 1);
        this.gTX.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.gTX.getPageContext(), skinType);
        a2.setVisibility(0);
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
    /* loaded from: classes3.dex */
    public class b {
        public BarImageView gUe;
        public LinearLayout gUf;
        public TextView gUg;
        public ImageView gUh;
        public TextView gUi;
        public FrameLayout gUj;
        public TextView gUk;
        public RelativeLayout gUl;
        public ImageView gUm;
        public ProgressBar gUn;
        public TextView gUo;
        public TextView gUp;
        public TextView gUq;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gUc;
        public TextView gUd;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gTY.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void cA(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gTX.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gTY.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.deX.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.deX.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.mS(z);
                dVar.mT(!z);
                dVar.mU(false);
                if (z) {
                    dVar.ug(signData.count_sign_num);
                    dVar.ui(signData.sign_bonus_point);
                    dVar.uf(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> byl = this.gTD.byl();
                    if (byl.contains(dVar)) {
                        byl.remove(dVar);
                        this.gTD.byk().add(dVar);
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

    public void byH() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gTY.entrySet()) {
                    entry.getValue().bzb();
                }
                this.gTY.clear();
            }
        }
    }
}
