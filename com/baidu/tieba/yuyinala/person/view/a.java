package com.baidu.tieba.yuyinala.person.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.at;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.b;
import com.baidu.tieba.yuyinala.person.PersonCardActivity;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private static final int hXv = "   ".length();
    private at hHQ;
    private View hXA;
    private List<AlaLiveMarkData> hXB;
    private List<AlaLiveMarkData> hXC;
    private List<AlaLiveMarkData> hXD;
    private TextView hXx;
    private TextView hXy;
    private TextView hXz;
    private View mContentView;
    private View mRootView;
    private PersonCardActivity oGZ;
    private int hXE = 0;
    private long lastClickTime = 0;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.oGZ = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.hXx = (TextView) this.mContentView.findViewById(a.f.user_mark_normal);
            this.hXy = (TextView) this.mContentView.findViewById(a.f.user_mark_extra);
            this.hXz = (TextView) this.mRootView.findViewById(a.f.user_name);
            this.hXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cpy();
                }
            });
            this.hXA = this.mContentView.findViewById(a.f.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.yuyinala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cpy() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.hHQ != null && com.baidu.live.af.a.SE().bCb.aRK != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.hHQ.user_id)) {
                    String str = com.baidu.live.af.a.SE().bCb.aRK.aRw;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.oGZ.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.af.a.SE().bCb.aRK.aRx;
                    if (str2 != null && this.hHQ != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.hHQ.user_id;
                        String str4 = this.hHQ.portrait;
                        String str5 = this.hHQ.user_nickname;
                        StringBuilder sb = new StringBuilder();
                        sb.append("id=");
                        sb.append(ExtraParamsManager.getEncryptionUserId(str3));
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("portrait=");
                        try {
                            sb.append(URLEncoder.encode(str4, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("nickname=");
                        try {
                            sb.append(URLEncoder.encode(str5, "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        if (!str2.contains("?")) {
                            sb.insert(0, "?");
                        } else {
                            sb.insert(0, ETAG.ITEM_SEPARATOR);
                        }
                        sb.insert(0, str2);
                        String sb2 = sb.toString();
                        this.oGZ.finish();
                        if (!TextUtils.isEmpty(sb2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913132, sb2));
                        }
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
            }
        }
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.hHQ = atVar;
            if (this.hXB == null) {
                this.hXB = new ArrayList();
            }
            this.hXB.clear();
            if (this.hXC == null) {
                this.hXC = new ArrayList();
            }
            this.hXC.clear();
            if (this.hXD == null) {
                this.hXD = new ArrayList();
            }
            this.hXD.clear();
            boolean cO = cO(atVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.hXB)) {
                a("", "", this.hXx, this.hXB);
            }
            if (!ListUtils.isEmpty(this.hXC) || cO) {
                int i = atVar.aQi;
                if (i <= 0) {
                    i = this.hXE;
                }
                a("  ", i + this.oGZ.getResources().getString(a.h.ala_count_mei), this.hXy, this.hXC);
                this.hXy.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_person_card_more, 0);
                this.hXA.setVisibility(0);
            } else {
                this.hXy.setText("");
                this.hXy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.hXA.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.hXD)) {
                a(cpz() + " ", "", this.hXz, this.hXD);
            }
        }
    }

    private String cpz() {
        String nameShow = this.hHQ.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                return TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            return nameShow;
        }
        return "";
    }

    private void a(String str, String str2, final TextView textView, List<AlaLiveMarkData> list) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str = str + "   ";
            }
        }
        String str3 = str + str2;
        if (list == null || list.isEmpty()) {
            textView.setText(str3);
            return;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (this.hHQ != null) {
                    alaLiveMarkData.userLevel = this.hHQ.level_id;
                    alaLiveMarkData.setupNewLevelMark();
                }
                if (alaLiveMarkData != null) {
                    final int i4 = length + (hXv * i3);
                    final int i5 = i4 + 1;
                    AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                    alaLiveMarkData2.mark_pic = alaLiveMarkData.mark_pic;
                    if (textView.getId() == a.f.user_name) {
                        alaLiveMarkData2.height = this.oGZ.getResources().getDimensionPixelSize(a.d.sdk_ds36);
                    }
                    alaLiveMarkData2.isWidthAutoFit = true;
                    new b(this.oGZ, alaLiveMarkData2, true, new b.a() { // from class: com.baidu.tieba.yuyinala.person.view.a.2
                        @Override // com.baidu.live.view.b.a
                        public void e(Bitmap bitmap) {
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(b bVar, Bitmap bitmap) {
                            spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                            textView.setText(spannableStringBuilder);
                        }
                    });
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private boolean cO(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                    linkedList.add(alaLiveMarkData);
                } else if (alaLiveMarkData.anchor_user_id.equals(this.oGZ.cpf())) {
                    linkedList.add(alaLiveMarkData);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return false;
        }
        boolean z = false;
        for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
            if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                this.hXC.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.hXD.add(alaLiveMarkData2);
            } else {
                this.hXB.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.hXE = this.hXC.size();
        if (this.hXE > 2) {
            this.hXC = this.hXC.subList(0, 2);
        }
        if (this.hXB.size() > 3) {
            this.hXB = this.hXB.subList(0, 3);
        }
        return z;
    }
}
