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
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private SignAllForumActivity iQH;
    private c iQn;
    private boolean isDestory;
    private ArrayList<d> ePw = new ArrayList<>();
    private HashMap<String, SignSingleModel> iQI = new HashMap<>();
    private boolean faU = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.iQH = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.iQn = cVar;
            this.ePw = cVar.cjO();
            if (this.ePw.size() == 0) {
                this.faU = false;
            } else {
                this.faU = true;
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
        if (this.faU) {
            return this.ePw.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ePw.size() > i) {
            return this.ePw.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View Ai(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.iQH.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.iQO = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.iQO.setIsRound(false);
            bVar.iQO.setGifIconSupport(false);
            bVar.iQQ = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.iQR = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.iQS = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.iQT = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.iQU = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.iQV = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.iQW = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.iQX = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.iQY = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.iQZ = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.iQP = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.iRa = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.iQH.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.iQM = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.iQN = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.iQH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iQH.getLayoutMode().onModeChanged(view);
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
            bVar.iQQ.setText(str);
            al.c(bVar.iQR, BitmapHelper.getSmallGradeResourceIdNew(dVar.ckb()));
            bVar.iQS.setText(dVar.ckc() + "/" + dVar.ckd());
            bVar.iRa.clearAnimation();
            if (dVar.aIt()) {
                bVar.iQP.setVisibility(0);
                bVar.iQZ.setVisibility(8);
                bVar.iQU.setVisibility(0);
                bVar.iQV.setVisibility(8);
                bVar.iQU.setText(String.format(this.iQH.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cka())));
                if (dVar.ckh()) {
                    bVar.iQS.setText(this.iQH.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.iRa.setVisibility(8);
                } else {
                    bVar.iQS.setText(dVar.ckc() + "/" + dVar.ckd());
                    bVar.iRa.setVisibility(0);
                }
                int ckg = dVar.ckg();
                if (ckg > 0) {
                    bVar.iRa.setVisibility(0);
                    bVar.iRa.setText("+" + ckg);
                } else {
                    bVar.iRa.setVisibility(8);
                }
            } else if (dVar.cke()) {
                bVar.iQP.setVisibility(0);
                bVar.iQZ.setVisibility(8);
                bVar.iRa.setVisibility(8);
                bVar.iQU.setVisibility(8);
                bVar.iQV.setVisibility(0);
                if (dVar.ckf()) {
                    bVar.iQW.setVisibility(4);
                    bVar.iQX.setVisibility(0);
                    bVar.iQY.setText(R.string.signallforum_resigning);
                } else {
                    bVar.iQW.setVisibility(0);
                    bVar.iQX.setVisibility(4);
                    bVar.iQY.setText(R.string.signallforum_resign);
                }
                bVar.iQV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.ckf()) {
                            bVar.iQW.setVisibility(4);
                            bVar.iQX.setVisibility(0);
                            bVar.iQY.setText(R.string.signallforum_resigning);
                            dVar.qA(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.iQH);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.iQI.put(str2, signSingleModel);
                            }
                            signSingleModel.ef(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.iQU.setVisibility(8);
                bVar.iQV.setVisibility(8);
                bVar.iRa.setVisibility(8);
                bVar.iQP.setVisibility(0);
                bVar.iQZ.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.iQO.setTag(avatar);
            bVar.iQO.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.faU) {
            return bgf();
        }
        int itemViewType = getItemViewType(i);
        View Ai = view == null ? Ai(itemViewType) : view;
        if (itemViewType == 1) {
            if (Ai.getTag() != null && (Ai.getTag() instanceof a)) {
                view2 = Ai;
                aVar = (a) Ai.getTag();
            } else {
                View Ai2 = Ai(itemViewType);
                view2 = Ai2;
                aVar = (a) Ai2.getTag();
            }
            this.iQH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.iQH.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.iQM.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            o(aVar.iQN, i);
            return view2;
        }
        if (Ai.getTag() == null || !(Ai.getTag() instanceof b)) {
            Ai = Ai(itemViewType);
        }
        a(Ai, viewGroup, i);
        return Ai;
    }

    private void o(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.iQn == null ? 7 : this.iQn.getLevel();
        if (this.ePw == null || this.ePw.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.ePw.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.ckb() >= level) {
                        if (next.aIt()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aIt()) {
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
            format = String.format(this.iQH.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.iQH.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bgf() {
        View inflate = LayoutInflater.from(this.iQH.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.iQH.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ad(R.string.sign_all_forum_nodata_tip, R.string.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iQH.getLayoutMode().setNightMode(skinType == 1);
        this.iQH.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.iQH.getPageContext(), skinType);
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
    /* loaded from: classes6.dex */
    public class b {
        public BarImageView iQO;
        public LinearLayout iQP;
        public TextView iQQ;
        public ImageView iQR;
        public TextView iQS;
        public FrameLayout iQT;
        public TextView iQU;
        public RelativeLayout iQV;
        public ImageView iQW;
        public ProgressBar iQX;
        public TextView iQY;
        public TextView iQZ;
        public TextView iRa;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView iQM;
        public TextView iQN;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.iQI.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ee(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.iQH.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.iQI.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.ePw.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.ePw.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.qy(z);
                dVar.qz(!z);
                dVar.qA(false);
                if (z) {
                    dVar.Af(signData.count_sign_num);
                    dVar.Ah(signData.sign_bonus_point);
                    dVar.Ae(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cjR = this.iQn.cjR();
                    if (cjR.contains(dVar)) {
                        cjR.remove(dVar);
                        this.iQn.cjQ().add(dVar);
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

    public void ckn() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.iQI.entrySet()) {
                    entry.getValue().ckG();
                }
                this.iQI.clear();
            }
        }
    }
}
