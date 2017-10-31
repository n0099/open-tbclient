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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
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
    private SkinInfo ZF;
    private String ZI;
    private TbRichTextVoiceInfo aob;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String eFW;
    private SmallTailInfo faG;
    private com.baidu.tbadk.data.a gpC;
    private com.baidu.tbadk.data.i gpD;
    private h gpG;
    private bc gpH;
    public boolean gpJ;
    private com.baidu.tbadk.widget.richText.f gpK;
    private String gpL;
    private String gpM;
    private TPointPost gpN;
    public int gpR;
    private ArrayList<PostData> gpw;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gpj = BdUniqueId.gen();
    public static final BdUniqueId gpk = BdUniqueId.gen();
    public static final BdUniqueId gpl = BdUniqueId.gen();
    public static final BdUniqueId ZG = BdUniqueId.gen();
    public static final BdUniqueId gpm = BdUniqueId.gen();
    public static final BdUniqueId Yr = BdUniqueId.gen();
    public static final BdUniqueId gpn = BdUniqueId.gen();
    public static final BdUniqueId gpo = BdUniqueId.gen();
    public static final BdUniqueId gpp = BdUniqueId.gen();
    public static final BdUniqueId gpq = BdUniqueId.gen();
    public static boolean gpr = false;
    private int gps = 0;
    private boolean gpx = false;
    private ArrayList<PostData> gpy = null;
    private TbRichText dVO = null;
    private boolean gpB = false;
    private boolean gpE = false;
    private boolean gpF = false;
    public boolean gpI = false;
    public int Zh = 0;
    private boolean gpO = false;
    private long cCa = 0;
    private boolean cCc = false;
    public boolean gpP = false;
    public boolean gpQ = false;
    public boolean gpS = false;
    public boolean gpT = true;
    public boolean cJc = false;
    public boolean gpU = false;
    private boolean gpV = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData YJ = new MetaData();
    private ArrayList<k> gpt = new ArrayList<>();
    private ArrayList<k> gpu = new ArrayList<>();
    private int gpv = 0;
    private int Zr = 0;
    private PraiseData YV = new PraiseData();
    private aq gpz = new aq();
    private c gpA = new c();
    private ArrayList<com.baidu.tbadk.data.a> ZD = new ArrayList<>();

    public PostData() {
        this.gpw = null;
        this.gpR = 0;
        this.gpw = new ArrayList<>();
        this.gpR = 0;
    }

    public ArrayList<PostData> bun() {
        return this.gpy;
    }

    public void buo() {
        this.gpy.clear();
        this.gpy = null;
        this.gpx = false;
    }

    public void z(PostData postData) {
        if (postData != null) {
            if (this.gpy == null) {
                this.gpy = new ArrayList<>();
                if (v.u(this.gpw) > 2) {
                    this.gpy.addAll(v.a(this.gpw, 0, 2));
                } else {
                    this.gpy.addAll(this.gpw);
                }
            }
            this.gpy.add(postData);
        }
    }

    public void A(PostData postData) {
        if (postData != null && this.gpw != null) {
            this.gpw.add(postData);
            bus();
        }
    }

    public void sw(String str) {
        if (this.gpy != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gpy.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gpy.remove(next);
                    return;
                }
            }
        }
    }

    public void mu(boolean z) {
        this.gpx = z;
    }

    public boolean bup() {
        return this.gpx;
    }

    public c buq() {
        return this.gpA;
    }

    public ArrayList<PostData> bur() {
        return this.gpw;
    }

    public void bus() {
        this.gpv++;
    }

    public void but() {
        this.gpv--;
    }

    public void tQ(int i) {
        this.gpv = i;
    }

    public boolean isGiftPost() {
        return this.gpE;
    }

    public void setIsGiftPost(boolean z) {
        this.gpE = z;
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

    public String aPB() {
        return this.eFW;
    }

    public int buu() {
        return this.floor_num;
    }

    public void tR(int i) {
        this.floor_num = i;
    }

    public boolean buv() {
        return this.gpF;
    }

    public void mv(boolean z) {
        this.gpF = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = am.r(j);
    }

    public String buw() {
        return this.date;
    }

    public MetaData rt() {
        return this.YJ;
    }

    public void a(MetaData metaData) {
        this.YJ = metaData;
    }

    public void a(PraiseData praiseData) {
        this.YV = praiseData;
    }

    public TbRichText aEt() {
        return this.dVO;
    }

    public void g(TbRichText tbRichText) {
        this.dVO = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aWP() {
        return this.faG;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.faG = smallTailInfo;
    }

    public com.baidu.tbadk.data.i bux() {
        return this.gpD;
    }

    public SkinInfo rP() {
        return this.ZF;
    }

    public void mw(boolean z) {
        this.gpV = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dVO != null && this.dVO.II() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.YJ != null && this.YJ.getIs_bawu() == 1 && "manager".equals(this.YJ.getBawu_type())) {
                str = " 吧主";
            } else if (this.YJ == null || this.YJ.getIs_bawu() != 1 || !"assist".equals(this.YJ.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = rt().getTShowInfoNew();
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
                                        super.onLoaded((C01271) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kL()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.dVO.isChanged = true;
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
            if (!StringUtils.isNull(this.YJ.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.YJ.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.YJ == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.YJ.getName_show() + str + "：");
                str2 = this.YJ.getUserName();
                str3 = this.YJ.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.YJ.getSealPrefix())) {
                Bitmap cR = aj.cR(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.YJ.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.YJ != null && this.YJ.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0080d.cp_link_tip_a);
                if (this.YJ != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.YJ.getName_show().length() + 1, str.length() + sb2.length() + this.YJ.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> II = this.dVO.II();
            if (II != null && II.size() > 0) {
                TbRichTextData tbRichTextData2 = II.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.IP() != null) {
                    if (this.gpV) {
                        int indexOf = tbRichTextData2.IP().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.IP().delete(0, indexOf + 1);
                        }
                        this.gpV = false;
                    }
                    tbRichTextData2.fV(sb.length());
                    tbRichTextData2.IP().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= II.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (II.get(i4) == null || II.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo IQ = II.get(i4).IQ();
                        II.remove(i4);
                        tbRichTextVoiceInfo = IQ;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fV(sb.length());
                tbRichTextData.append(spannableString);
                II.add(0, tbRichTextData);
            }
        }
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.dVO != null && this.dVO.II() != null) {
            String str3 = z ? " 楼主" : "";
            String sb = new StringBuilder().toString();
            String name_show = this.YJ.getName_show();
            if (com.baidu.adp.lib.util.k.aP(this.YJ.getName_show()) > 14) {
                name_show = am.e(this.YJ.getName_show(), 14, "...");
            }
            if (this.YJ != null) {
                spannableString = new SpannableString(sb + name_show + str3 + "：");
                str = this.YJ.getUserName();
                str2 = this.YJ.getUserId();
            } else {
                str = null;
                spannableString = new SpannableString(sb + str3 + "：");
                str2 = null;
            }
            if (!StringUtils.isNull(this.YJ.getSealPrefix())) {
                Bitmap cR = aj.cR(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds2));
                int length = this.YJ.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, length, length + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0080d.cp_link_tip_a);
                if (this.YJ != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb.length() + this.YJ.getName_show().length() + 1, sb.length() + this.YJ.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length() + this.YJ.getName_show().length() + 1, str3.length() + sb.length() + this.YJ.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb.length(), sb.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length(), str3.length() + sb.length(), 17);
                }
            }
            ArrayList<TbRichTextData> II = this.dVO.II();
            if (II != null && II.size() > 0) {
                TbRichTextData tbRichTextData2 = II.get(0);
                if (tbRichTextData2.IP() != null) {
                    tbRichTextData2.IP().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < II.size()) {
                        if (II.get(i) == null || II.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = II.get(i).IQ();
                            II.remove(i);
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
                II.add(0, tbRichTextData);
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

    public int buy() {
        return this.gpv;
    }

    public void bV(Context context) {
        int type;
        int i;
        int i2;
        if (this.gpt != null) {
            int i3 = -1;
            int size = this.gpu.size();
            if (size > 0) {
                try {
                    i3 = this.gpu.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gpt.size()) {
                k kVar = this.gpt.get(i4);
                if (k.bV(i5, kVar.getType())) {
                    this.gpu.get(size - 1).b(kVar.bU(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gpu.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bU(context));
                        this.gpu.add(kVar2);
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

    public void bW(Context context) {
        try {
            if (this.dVO != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dVO.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gpu == null || this.gpu.size() == 0) {
                bV(context);
            }
            ArrayList<k> arrayList = this.gpu;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bug() != null) {
                            sb.append((CharSequence) next.bug());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fH = TbFaceManager.Ef().fH(next.getText());
                        if (fH != null) {
                            sb.append("[");
                            sb.append(fH);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !am.isEmpty(next.buf())) {
                        sb.append("[").append(next.buf()).append("]");
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
                this.date = am.r(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gpE = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.YJ = metaData;
                }
                if ((this.YJ.getUserId() == null || this.YJ.getUserId().length() <= 0 || this.YJ.getUserId().equals("0")) && metaData2 != null) {
                    this.YJ = metaData2;
                }
                this.dVO = TbRichTextView.a(context, subPostList.content, z);
                if (this.dVO != null) {
                    this.dVO.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = am.r(this.time);
                this.eFW = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.YJ = metaData;
                }
                this.gpP = post.need_log.intValue() == 1;
                this.gpQ = post.img_num_abtest.intValue() == 1;
                this.gpH = new bc();
                this.gpH.parserProtobuf(post.from_forum);
                if (this.YJ.getUserId() == null || this.YJ.getUserId().length() <= 0 || this.YJ.getUserId().equals("0")) {
                    this.YJ.parserProtobuf(post.author);
                }
                if (this.YJ != null && context != null) {
                    this.gpL = this.YJ.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.gpM = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.YJ.getLevel_id()));
                }
                this.gpB = post.is_ntitle.intValue() == 1;
                this.gpv = post.sub_post_number.intValue();
                this.gpG = new h(post.tpoint_post);
                this.dVO = TbRichTextView.a(context, post.content, true);
                if (this.dVO != null) {
                    this.dVO.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dVO.fU(this.floor_num);
                    if (this.YJ != null) {
                        this.dVO.setAuthorId(this.YJ.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gpE = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gpw.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gpA.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gpC = new com.baidu.tbadk.data.a();
                    this.gpC.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gpD = new com.baidu.tbadk.data.i();
                    this.gpD.a(post.lbs_info);
                }
                this.Zr = post.storecount.intValue();
                this.gpz.a(post.present);
                this.YV.setUserMap(this.userMap);
                this.YV.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.faG = new SmallTailInfo();
                    this.faG.id = post.signature.signature_id.intValue();
                    this.faG.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.faG.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.faG.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.faG.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.ZD.add(aVar);
                    }
                }
                this.ZF = post.skin_info;
                this.ZI = post.lego_card;
                this.gpN = post.tpoint_post;
                if (post.agree != null) {
                    this.gpO = true;
                    this.cCc = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.cCa = post.agree.agree_num.longValue();
                    } else {
                        this.cCa = 0L;
                    }
                } else {
                    this.gpO = false;
                }
                this.gpU = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eYU;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.eYU = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.eYU));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gqb;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gqb = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0080d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gqb != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.gqb.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bX(Context context) {
        ArrayList<TbRichTextData> II;
        if (this.dVO == null || (II = this.dVO.II()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = II.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.IP().toString());
            } else if (next.getType() == 17) {
                String str = next.IT().mGifInfo.mSharpText;
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

    public PreLoadImageInfo buz() {
        ArrayList<TbRichTextData> II;
        if (this.dVO != null && (II = this.dVO.II()) != null) {
            Iterator<TbRichTextData> it = II.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.IO().getWidth();
                    preLoadImageInfo.height = next.IO().getHeight();
                    preLoadImageInfo.imgUrl = next.IO().Jc();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String buA() {
        j btY;
        PreLoadImageInfo buz = buz();
        if (buz != null && !StringUtils.isNull(buz.imgUrl)) {
            return buz.imgUrl;
        }
        if (this.gpG != null && (btY = this.gpG.btY()) != null && !StringUtils.isNull(btY.bud())) {
            return btY.bud();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> II;
        if (this.dVO == null || (II = this.dVO.II()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = II.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.IO().getWidth();
                preLoadImageInfo.height = next.IO().getHeight();
                preLoadImageInfo.imgUrl = next.IO().Jc();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.IT() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.IT().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.IT().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.IT();
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
        if (this.YJ == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.YJ.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.gps == 52) {
            return gpp;
        }
        if (this.gps == 2) {
            return gpl;
        }
        if (this.gps == 1) {
            return ZG;
        }
        if (this.gps == 36) {
            return gpm;
        }
        if (this.gps == 40 || this.gps == 50) {
            return Yr;
        }
        if (this.gps == 41) {
            return gpn;
        }
        if (this.gps == 53) {
            return gpq;
        }
        if (buu() == 1) {
            return gpj;
        }
        return gpk;
    }

    public void setPostType(int i) {
        this.gps = i;
    }

    public aq buB() {
        return this.gpz;
    }

    public void a(aq aqVar) {
        this.gpz = aqVar;
    }

    public h buC() {
        return this.gpG;
    }

    public com.baidu.tbadk.widget.richText.f IS() {
        if (this.gpK != null) {
            return this.gpK;
        }
        if (this.dVO != null && v.u(this.dVO.II()) > 0) {
            Iterator<TbRichTextData> it = this.dVO.II().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gpK = next.IS();
                    return this.gpK;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo IQ() {
        if (this.aob != null) {
            return this.aob;
        }
        if (this.dVO != null && v.u(this.dVO.II()) > 0) {
            Iterator<TbRichTextData> it = this.dVO.II().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aob = next.IQ();
                    return this.aob;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> buD() {
        return this.ZD;
    }

    public String buE() {
        return this.gpL;
    }

    public String buF() {
        return this.gpM;
    }

    public String sq() {
        return this.ZI;
    }

    public void st() {
        if (this.Zh == 0) {
            this.Zh = 1;
        }
    }

    public long buG() {
        return this.cCa;
    }

    public void cN(long j) {
        this.cCa = j;
    }

    public boolean buH() {
        return this.cCc;
    }

    public void mx(boolean z) {
        this.cCc = z;
    }

    public bc buI() {
        return this.gpH;
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
