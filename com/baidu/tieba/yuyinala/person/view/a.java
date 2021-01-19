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
/* loaded from: classes10.dex */
public class a {
    private static final int hSO = "   ".length();
    private at hDk;
    private TextView hSQ;
    private TextView hSR;
    private TextView hSS;
    private View hST;
    private List<AlaLiveMarkData> hSU;
    private List<AlaLiveMarkData> hSV;
    private List<AlaLiveMarkData> hSW;
    private int hSX = 0;
    private long lastClickTime = 0;
    private View mContentView;
    private View mRootView;
    private PersonCardActivity oCv;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.oCv = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.hSQ = (TextView) this.mContentView.findViewById(a.f.user_mark_normal);
            this.hSR = (TextView) this.mContentView.findViewById(a.f.user_mark_extra);
            this.hSS = (TextView) this.mRootView.findViewById(a.f.user_name);
            this.hSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.clH();
                }
            });
            this.hST = this.mContentView.findViewById(a.f.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.yuyinala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void clH() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.hDk != null && com.baidu.live.af.a.OJ().bxp.aMX != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.hDk.user_id)) {
                    String str = com.baidu.live.af.a.OJ().bxp.aMX.aMJ;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.oCv.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.af.a.OJ().bxp.aMX.aMK;
                    if (str2 != null && this.hDk != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.hDk.user_id;
                        String str4 = this.hDk.portrait;
                        String str5 = this.hDk.user_nickname;
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
                        this.oCv.finish();
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
            this.hDk = atVar;
            if (this.hSU == null) {
                this.hSU = new ArrayList();
            }
            this.hSU.clear();
            if (this.hSV == null) {
                this.hSV = new ArrayList();
            }
            this.hSV.clear();
            if (this.hSW == null) {
                this.hSW = new ArrayList();
            }
            this.hSW.clear();
            boolean cO = cO(atVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.hSU)) {
                a("", "", this.hSQ, this.hSU);
            }
            if (!ListUtils.isEmpty(this.hSV) || cO) {
                int i = atVar.aLv;
                if (i <= 0) {
                    i = this.hSX;
                }
                a("  ", i + this.oCv.getResources().getString(a.h.ala_count_mei), this.hSR, this.hSV);
                this.hSR.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_person_card_more, 0);
                this.hST.setVisibility(0);
            } else {
                this.hSR.setText("");
                this.hSR.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.hST.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.hSW)) {
                a(clI() + " ", "", this.hSS, this.hSW);
            }
        }
    }

    private String clI() {
        String nameShow = this.hDk.getNameShow();
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
                if (this.hDk != null) {
                    alaLiveMarkData.userLevel = this.hDk.level_id;
                    alaLiveMarkData.setupNewLevelMark();
                }
                if (alaLiveMarkData != null) {
                    final int i4 = length + (hSO * i3);
                    final int i5 = i4 + 1;
                    AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                    alaLiveMarkData2.mark_pic = alaLiveMarkData.mark_pic;
                    if (textView.getId() == a.f.user_name) {
                        alaLiveMarkData2.height = this.oCv.getResources().getDimensionPixelSize(a.d.sdk_ds36);
                    }
                    alaLiveMarkData2.isWidthAutoFit = true;
                    new b(this.oCv, alaLiveMarkData2, true, new b.a() { // from class: com.baidu.tieba.yuyinala.person.view.a.2
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
                } else if (alaLiveMarkData.anchor_user_id.equals(this.oCv.clo())) {
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
                this.hSV.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.hSW.add(alaLiveMarkData2);
            } else {
                this.hSU.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.hSX = this.hSV.size();
        if (this.hSX > 2) {
            this.hSV = this.hSV.subList(0, 2);
        }
        if (this.hSU.size() > 3) {
            this.hSU = this.hSU.subList(0, 3);
        }
        return z;
    }
}
