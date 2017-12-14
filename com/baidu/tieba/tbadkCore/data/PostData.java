package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.f, ae {
    private SkinInfo ZS;
    private String ZV;
    private OriginalThreadInfo aaC;
    private TbRichTextVoiceInfo aom;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String ePc;
    private SmallTailInfo fiU;
    public AlaLiveInfoCoreData gCA;
    private boolean gCC;
    private ArrayList<PostData> gCa;
    private com.baidu.tbadk.data.a gCh;
    private com.baidu.tbadk.data.i gCi;
    private h gCl;
    private ay gCm;
    public boolean gCo;
    private com.baidu.tbadk.widget.richText.f gCp;
    private String gCq;
    private String gCr;
    private TPointPost gCs;
    public int gCw;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gBN = BdUniqueId.gen();
    public static final BdUniqueId gBO = BdUniqueId.gen();
    public static final BdUniqueId gBP = BdUniqueId.gen();
    public static final BdUniqueId ZT = BdUniqueId.gen();
    public static final BdUniqueId gBQ = BdUniqueId.gen();
    public static final BdUniqueId YD = BdUniqueId.gen();
    public static final BdUniqueId gBR = BdUniqueId.gen();
    public static final BdUniqueId gBS = BdUniqueId.gen();
    public static final BdUniqueId gBT = BdUniqueId.gen();
    public static final BdUniqueId gBU = BdUniqueId.gen();
    public static boolean gBV = false;
    private int gBW = 0;
    private boolean gCb = false;
    private ArrayList<PostData> gCc = null;
    private TbRichText gCd = null;
    private boolean gCg = false;
    private boolean gCj = false;
    private boolean gCk = false;
    public boolean gCn = false;
    public int Zu = 0;
    private boolean gCt = false;
    private long cLH = 0;
    private boolean cLJ = false;
    public boolean gCu = false;
    public boolean gCv = false;
    public boolean gCx = false;
    public boolean gCy = true;
    public boolean cTd = false;
    public boolean gCz = false;
    private boolean gCB = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData YW = new MetaData();
    private ArrayList<k> gBX = new ArrayList<>();
    private ArrayList<k> gBY = new ArrayList<>();
    private int gBZ = 0;
    private int ZE = 0;
    private PraiseData Zi = new PraiseData();
    private am gCe = new am();
    private c gCf = new c();
    private ArrayList<com.baidu.tbadk.data.a> ZQ = new ArrayList<>();

    public PostData() {
        this.gCa = null;
        this.gCw = 0;
        this.gCa = new ArrayList<>();
        this.gCw = 0;
    }

    public ArrayList<PostData> bwO() {
        return this.gCc;
    }

    public void bwP() {
        this.gCc.clear();
        this.gCc = null;
        this.gCb = false;
    }

    public void z(PostData postData) {
        if (postData != null) {
            if (this.gCc == null) {
                this.gCc = new ArrayList<>();
                if (v.v(this.gCa) > 2) {
                    this.gCc.addAll(v.a(this.gCa, 0, 2));
                } else {
                    this.gCc.addAll(this.gCa);
                }
            }
            this.gCc.add(postData);
        }
    }

    public void A(PostData postData) {
        if (postData != null && this.gCa != null) {
            this.gCa.add(postData);
            bwT();
        }
    }

    public void te(String str) {
        if (this.gCc != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gCc.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gCc.remove(next);
                    return;
                }
            }
        }
    }

    public void nb(boolean z) {
        this.gCb = z;
    }

    public boolean bwQ() {
        return this.gCb;
    }

    public c bwR() {
        return this.gCf;
    }

    public ArrayList<PostData> bwS() {
        return this.gCa;
    }

    public void bwT() {
        this.gBZ++;
    }

    public void bwU() {
        this.gBZ--;
    }

    public void uv(int i) {
        this.gBZ = i;
    }

    public boolean isGiftPost() {
        return this.gCj;
    }

    public void setIsGiftPost(boolean z) {
        this.gCj = z;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String aRd() {
        return this.ePc;
    }

    public int bwV() {
        return this.floor_num;
    }

    public void uw(int i) {
        this.floor_num = i;
    }

    public boolean bwW() {
        return this.gCk;
    }

    public void nc(boolean z) {
        this.gCk = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.am.r(j);
    }

    public String bwX() {
        return this.date;
    }

    public MetaData rv() {
        return this.YW;
    }

    public void a(MetaData metaData) {
        this.YW = metaData;
    }

    public void a(PraiseData praiseData) {
        this.Zi = praiseData;
    }

    public TbRichText bwY() {
        return this.gCd;
    }

    public void d(TbRichText tbRichText) {
        this.gCd = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aYe() {
        return this.fiU;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fiU = smallTailInfo;
    }

    public com.baidu.tbadk.data.i bwZ() {
        return this.gCi;
    }

    public SkinInfo rR() {
        return this.ZS;
    }

    public void nd(boolean z) {
        this.gCB = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gCd != null && this.gCd.Jr() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.YW != null && this.YW.getIs_bawu() == 1 && "manager".equals(this.YW.getBawu_type())) {
                str = " 吧主";
            } else if (this.YW == null || this.YW.getIs_bawu() != 1 || !"assist".equals(this.YW.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = rv().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fJ().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fJ().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C01441) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kL()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gCd.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.c(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.YW.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.YW.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.YW == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.YW.getName_show() + str + "：");
                str2 = this.YW.getUserName();
                str3 = this.YW.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.YW.getSealPrefix())) {
                Bitmap cR = aj.cR(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.YW.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.YW != null && this.YW.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0096d.cp_link_tip_a);
                if (this.YW != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.YW.getName_show().length() + 1, str.length() + sb2.length() + this.YW.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Jr = this.gCd.Jr();
            if (Jr != null && Jr.size() > 0) {
                TbRichTextData tbRichTextData2 = Jr.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Jy() != null) {
                    if (this.gCB) {
                        int indexOf = tbRichTextData2.Jy().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Jy().delete(0, indexOf + 1);
                        }
                        this.gCB = false;
                    }
                    tbRichTextData2.gc(sb.length());
                    tbRichTextData2.Jy().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Jr.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Jr.get(i4) == null || Jr.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Jz = Jr.get(i4).Jz();
                        Jr.remove(i4);
                        tbRichTextVoiceInfo = Jz;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.gc(sb.length());
                tbRichTextData.append(spannableString);
                Jr.add(0, tbRichTextData);
            }
        }
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.gCd != null && this.gCd.Jr() != null) {
            String str3 = z ? " 楼主" : "";
            String sb = new StringBuilder().toString();
            String name_show = this.YW.getName_show();
            if (com.baidu.adp.lib.util.k.aP(this.YW.getName_show()) > 14) {
                name_show = com.baidu.tbadk.core.util.am.e(this.YW.getName_show(), 14, "...");
            }
            if (this.YW != null) {
                spannableString = new SpannableString(sb + name_show + str3 + "：");
                str = this.YW.getUserName();
                str2 = this.YW.getUserId();
            } else {
                str = null;
                spannableString = new SpannableString(sb + str3 + "：");
                str2 = null;
            }
            if (!StringUtils.isNull(this.YW.getSealPrefix())) {
                Bitmap cR = aj.cR(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds2));
                int length = this.YW.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, length, length + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0096d.cp_link_tip_a);
                if (this.YW != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb.length() + this.YW.getName_show().length() + 1, sb.length() + this.YW.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length() + this.YW.getName_show().length() + 1, str3.length() + sb.length() + this.YW.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb.length(), sb.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length(), str3.length() + sb.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Jr = this.gCd.Jr();
            if (Jr != null && Jr.size() > 0) {
                TbRichTextData tbRichTextData2 = Jr.get(0);
                if (tbRichTextData2.Jy() != null) {
                    tbRichTextData2.Jy().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < Jr.size()) {
                        if (Jr.get(i) == null || Jr.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = Jr.get(i).Jz();
                            Jr.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.append(spannableString);
                Jr.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap kK;
        if (aVar == null || (kK = aVar.kK()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kK);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bxa() {
        return this.gBZ;
    }

    public void cc(Context context) {
        int type;
        int i;
        int i2;
        if (this.gBX != null) {
            int i3 = -1;
            int size = this.gBY.size();
            if (size > 0) {
                try {
                    i3 = this.gBY.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gBX.size()) {
                k kVar = this.gBX.get(i4);
                if (k.bW(i5, kVar.getType())) {
                    this.gBY.get(size - 1).b(kVar.cb(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gBY.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cb(context));
                        this.gBY.add(kVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void cd(Context context) {
        try {
            if (this.gCd != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gCd.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gBY == null || this.gBY.size() == 0) {
                cc(context);
            }
            ArrayList<k> arrayList = this.gBY;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bwH() != null) {
                            sb.append((CharSequence) next.bwH());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fN = TbFaceManager.Ez().fN(next.getText());
                        if (fN != null) {
                            sb.append("[");
                            sb.append(fN);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.am.isEmpty(next.bwG())) {
                        sb.append("[").append(next.bwG()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = com.baidu.tbadk.core.util.am.r(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gCj = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.YW = metaData;
                }
                if ((this.YW.getUserId() == null || this.YW.getUserId().length() <= 0 || this.YW.getUserId().equals("0")) && metaData2 != null) {
                    this.YW = metaData2;
                }
                this.gCd = TbRichTextView.a(context, subPostList.content, z);
                if (this.gCd != null) {
                    this.gCd.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = com.baidu.tbadk.core.util.am.r(this.time);
                this.ePc = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.YW = metaData;
                }
                this.gCu = post.need_log.intValue() == 1;
                this.gCv = post.img_num_abtest.intValue() == 1;
                this.gCm = new ay();
                this.gCm.parserProtobuf(post.from_forum);
                if (this.YW.getUserId() == null || this.YW.getUserId().length() <= 0 || this.YW.getUserId().equals("0")) {
                    this.YW.parserProtobuf(post.author);
                }
                if (this.YW != null && context != null) {
                    this.gCq = this.YW.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.gCr = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.YW.getLevel_id()));
                }
                this.gCg = post.is_ntitle.intValue() == 1;
                this.gBZ = post.sub_post_number.intValue();
                this.gCl = new h(post.tpoint_post);
                this.gCd = TbRichTextView.a(context, post.content, true);
                if (this.gCd != null) {
                    this.gCd.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gCd.gb(this.floor_num);
                    if (this.YW != null) {
                        this.gCd.setAuthorId(this.YW.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gCj = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gCa.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gCf.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gCh = new com.baidu.tbadk.data.a();
                    this.gCh.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gCi = new com.baidu.tbadk.data.i();
                    this.gCi.a(post.lbs_info);
                }
                this.ZE = post.storecount.intValue();
                this.gCe.a(post.present);
                this.Zi.setUserMap(this.userMap);
                this.Zi.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fiU = new SmallTailInfo();
                    this.fiU.id = post.signature.signature_id.intValue();
                    this.fiU.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fiU.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fiU.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fiU.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.ZQ.add(aVar);
                    }
                }
                this.ZS = post.skin_info;
                this.ZV = post.lego_card;
                this.gCs = post.tpoint_post;
                if (post.agree != null) {
                    this.gCt = true;
                    this.cLJ = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.cLH = post.agree.agree_num.longValue();
                    } else {
                        this.cLH = 0L;
                    }
                } else {
                    this.gCt = false;
                }
                this.gCz = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aaC = new OriginalThreadInfo();
                    this.aaC.parser(post.origin_thread_info);
                } else {
                    this.aaC = null;
                }
                this.gCC = post.is_fold.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fhg;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.fhg = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.fhg));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gCI;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gCI = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0096d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gCI != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.gCI.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ce(Context context) {
        ArrayList<TbRichTextData> Jr;
        if (this.gCd == null || (Jr = this.gCd.Jr()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Jr.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Jy().toString());
            } else if (next.getType() == 17) {
                String str = next.JC().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.j.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.j.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo bxb() {
        ArrayList<TbRichTextData> Jr;
        if (this.gCd != null && (Jr = this.gCd.Jr()) != null) {
            Iterator<TbRichTextData> it = Jr.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Jx().getWidth();
                    preLoadImageInfo.height = next.Jx().getHeight();
                    preLoadImageInfo.imgUrl = next.Jx().JL();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String bxc() {
        j bwz;
        PreLoadImageInfo bxb = bxb();
        if (bxb != null && !StringUtils.isNull(bxb.imgUrl)) {
            return bxb.imgUrl;
        }
        if (this.gCl != null && (bwz = this.gCl.bwz()) != null && !StringUtils.isNull(bwz.bwE())) {
            return bwz.bwE();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Jr;
        if (this.gCd == null || (Jr = this.gCd.Jr()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Jr.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Jx().getWidth();
                preLoadImageInfo.height = next.Jx().getHeight();
                preLoadImageInfo.imgUrl = next.Jx().JL();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.JC() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.JC().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.JC().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.JC();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.YW == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.YW.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.gBW == 52) {
            return gBT;
        }
        if (this.gBW == 2) {
            return gBP;
        }
        if (this.gBW == 1) {
            return ZT;
        }
        if (this.gBW == 36) {
            return gBQ;
        }
        if (this.gBW == 40 || this.gBW == 50) {
            return YD;
        }
        if (this.gBW == 41) {
            return gBR;
        }
        if (this.gBW == 53) {
            return gBU;
        }
        if (bwV() == 1) {
            return gBN;
        }
        return gBO;
    }

    public void setPostType(int i) {
        this.gBW = i;
    }

    public am bxd() {
        return this.gCe;
    }

    public void a(am amVar) {
        this.gCe = amVar;
    }

    public h bxe() {
        return this.gCl;
    }

    public com.baidu.tbadk.widget.richText.f JB() {
        if (this.gCp != null) {
            return this.gCp;
        }
        if (this.gCd != null && v.v(this.gCd.Jr()) > 0) {
            Iterator<TbRichTextData> it = this.gCd.Jr().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gCp = next.JB();
                    return this.gCp;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Jz() {
        if (this.aom != null) {
            return this.aom;
        }
        if (this.gCd != null && v.v(this.gCd.Jr()) > 0) {
            Iterator<TbRichTextData> it = this.gCd.Jr().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aom = next.Jz();
                    return this.aom;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> bxf() {
        return this.ZQ;
    }

    public String bxg() {
        return this.gCq;
    }

    public String bxh() {
        return this.gCr;
    }

    public String sr() {
        return this.ZV;
    }

    public void su() {
        if (this.Zu == 0) {
            this.Zu = 1;
        }
    }

    public long bxi() {
        return this.cLH;
    }

    public void cX(long j) {
        this.cLH = j;
    }

    public boolean bxj() {
        return this.cLJ;
    }

    public void ne(boolean z) {
        this.cLJ = z;
    }

    public OriginalThreadInfo bxk() {
        return this.aaC;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.aaC = originalThreadInfo;
    }

    public boolean bxl() {
        return this.gCC;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PostData)) {
            return false;
        }
        return (((PostData) obj).getId() == null || getId() == null || !getId().equals(((PostData) obj).getId())) ? false : true;
    }

    public int hashCode() {
        return getId() != null ? getId().hashCode() : "".hashCode();
    }
}
