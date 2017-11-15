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
    private TbRichTextVoiceInfo aoa;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String eGq;
    private SmallTailInfo fbb;
    private com.baidu.tbadk.data.a gqF;
    private com.baidu.tbadk.data.i gqG;
    private h gqJ;
    private bc gqK;
    public boolean gqM;
    private com.baidu.tbadk.widget.richText.f gqN;
    private String gqO;
    private String gqP;
    private TPointPost gqQ;
    public int gqU;
    private ArrayList<PostData> gqz;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gqm = BdUniqueId.gen();
    public static final BdUniqueId gqn = BdUniqueId.gen();
    public static final BdUniqueId gqo = BdUniqueId.gen();
    public static final BdUniqueId ZG = BdUniqueId.gen();
    public static final BdUniqueId gqp = BdUniqueId.gen();
    public static final BdUniqueId Yr = BdUniqueId.gen();
    public static final BdUniqueId gqq = BdUniqueId.gen();
    public static final BdUniqueId gqr = BdUniqueId.gen();
    public static final BdUniqueId gqs = BdUniqueId.gen();
    public static final BdUniqueId gqt = BdUniqueId.gen();
    public static boolean gqu = false;
    private int gqv = 0;
    private boolean gqA = false;
    private ArrayList<PostData> gqB = null;
    private TbRichText dVS = null;
    private boolean gqE = false;
    private boolean gqH = false;
    private boolean gqI = false;
    public boolean gqL = false;
    public int Zh = 0;
    private boolean gqR = false;
    private long cCt = 0;
    private boolean cCv = false;
    public boolean gqS = false;
    public boolean gqT = false;
    public boolean gqV = false;
    public boolean gqW = true;
    public boolean cJv = false;
    public boolean gqX = false;
    private boolean gqY = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData YJ = new MetaData();
    private ArrayList<k> gqw = new ArrayList<>();
    private ArrayList<k> gqx = new ArrayList<>();
    private int gqy = 0;
    private int Zr = 0;
    private PraiseData YV = new PraiseData();
    private aq gqC = new aq();
    private c gqD = new c();
    private ArrayList<com.baidu.tbadk.data.a> ZD = new ArrayList<>();

    public PostData() {
        this.gqz = null;
        this.gqU = 0;
        this.gqz = new ArrayList<>();
        this.gqU = 0;
    }

    public ArrayList<PostData> buz() {
        return this.gqB;
    }

    public void buA() {
        this.gqB.clear();
        this.gqB = null;
        this.gqA = false;
    }

    public void z(PostData postData) {
        if (postData != null) {
            if (this.gqB == null) {
                this.gqB = new ArrayList<>();
                if (v.u(this.gqz) > 2) {
                    this.gqB.addAll(v.a(this.gqz, 0, 2));
                } else {
                    this.gqB.addAll(this.gqz);
                }
            }
            this.gqB.add(postData);
        }
    }

    public void A(PostData postData) {
        if (postData != null && this.gqz != null) {
            this.gqz.add(postData);
            buE();
        }
    }

    public void sC(String str) {
        if (this.gqB != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gqB.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gqB.remove(next);
                    return;
                }
            }
        }
    }

    public void mC(boolean z) {
        this.gqA = z;
    }

    public boolean buB() {
        return this.gqA;
    }

    public c buC() {
        return this.gqD;
    }

    public ArrayList<PostData> buD() {
        return this.gqz;
    }

    public void buE() {
        this.gqy++;
    }

    public void buF() {
        this.gqy--;
    }

    public void tU(int i) {
        this.gqy = i;
    }

    public boolean isGiftPost() {
        return this.gqH;
    }

    public void setIsGiftPost(boolean z) {
        this.gqH = z;
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

    public String aPJ() {
        return this.eGq;
    }

    public int buG() {
        return this.floor_num;
    }

    public void tV(int i) {
        this.floor_num = i;
    }

    public boolean buH() {
        return this.gqI;
    }

    public void mD(boolean z) {
        this.gqI = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = am.r(j);
    }

    public String buI() {
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

    public TbRichText aEx() {
        return this.dVS;
    }

    public void g(TbRichText tbRichText) {
        this.dVS = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aWX() {
        return this.fbb;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fbb = smallTailInfo;
    }

    public com.baidu.tbadk.data.i buJ() {
        return this.gqG;
    }

    public SkinInfo rP() {
        return this.ZF;
    }

    public void mE(boolean z) {
        this.gqY = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dVS != null && this.dVS.IT() != null) {
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
                                        super.onLoaded((C01301) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kL()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.dVS.isChanged = true;
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
                Bitmap cQ = aj.cQ(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
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
            ArrayList<TbRichTextData> IT = this.dVS.IT();
            if (IT != null && IT.size() > 0) {
                TbRichTextData tbRichTextData2 = IT.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Ja() != null) {
                    if (this.gqY) {
                        int indexOf = tbRichTextData2.Ja().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Ja().delete(0, indexOf + 1);
                        }
                        this.gqY = false;
                    }
                    tbRichTextData2.fU(sb.length());
                    tbRichTextData2.Ja().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= IT.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (IT.get(i4) == null || IT.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Jb = IT.get(i4).Jb();
                        IT.remove(i4);
                        tbRichTextVoiceInfo = Jb;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fU(sb.length());
                tbRichTextData.append(spannableString);
                IT.add(0, tbRichTextData);
            }
        }
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.dVS != null && this.dVS.IT() != null) {
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
                Bitmap cQ = aj.cQ(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
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
            ArrayList<TbRichTextData> IT = this.dVS.IT();
            if (IT != null && IT.size() > 0) {
                TbRichTextData tbRichTextData2 = IT.get(0);
                if (tbRichTextData2.Ja() != null) {
                    tbRichTextData2.Ja().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < IT.size()) {
                        if (IT.get(i) == null || IT.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = IT.get(i).Jb();
                            IT.remove(i);
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
                IT.add(0, tbRichTextData);
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

    public int buK() {
        return this.gqy;
    }

    public void bV(Context context) {
        int type;
        int i;
        int i2;
        if (this.gqw != null) {
            int i3 = -1;
            int size = this.gqx.size();
            if (size > 0) {
                try {
                    i3 = this.gqx.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gqw.size()) {
                k kVar = this.gqw.get(i4);
                if (k.bU(i5, kVar.getType())) {
                    this.gqx.get(size - 1).b(kVar.bU(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gqx.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.bU(context));
                        this.gqx.add(kVar2);
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
            if (this.dVS != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dVS.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gqx == null || this.gqx.size() == 0) {
                bV(context);
            }
            ArrayList<k> arrayList = this.gqx;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bus() != null) {
                            sb.append((CharSequence) next.bus());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fI = TbFaceManager.Er().fI(next.getText());
                        if (fI != null) {
                            sb.append("[");
                            sb.append(fI);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !am.isEmpty(next.bur())) {
                        sb.append("[").append(next.bur()).append("]");
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
                this.gqH = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.YJ = metaData;
                }
                if ((this.YJ.getUserId() == null || this.YJ.getUserId().length() <= 0 || this.YJ.getUserId().equals("0")) && metaData2 != null) {
                    this.YJ = metaData2;
                }
                this.dVS = TbRichTextView.a(context, subPostList.content, z);
                if (this.dVS != null) {
                    this.dVS.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.eGq = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.YJ = metaData;
                }
                this.gqS = post.need_log.intValue() == 1;
                this.gqT = post.img_num_abtest.intValue() == 1;
                this.gqK = new bc();
                this.gqK.parserProtobuf(post.from_forum);
                if (this.YJ.getUserId() == null || this.YJ.getUserId().length() <= 0 || this.YJ.getUserId().equals("0")) {
                    this.YJ.parserProtobuf(post.author);
                }
                if (this.YJ != null && context != null) {
                    this.gqO = this.YJ.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.gqP = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.YJ.getLevel_id()));
                }
                this.gqE = post.is_ntitle.intValue() == 1;
                this.gqy = post.sub_post_number.intValue();
                this.gqJ = new h(post.tpoint_post);
                this.dVS = TbRichTextView.a(context, post.content, true);
                if (this.dVS != null) {
                    this.dVS.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dVS.fT(this.floor_num);
                    if (this.YJ != null) {
                        this.dVS.setAuthorId(this.YJ.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gqH = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gqz.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gqD.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gqF = new com.baidu.tbadk.data.a();
                    this.gqF.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gqG = new com.baidu.tbadk.data.i();
                    this.gqG.a(post.lbs_info);
                }
                this.Zr = post.storecount.intValue();
                this.gqC.a(post.present);
                this.YV.setUserMap(this.userMap);
                this.YV.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fbb = new SmallTailInfo();
                    this.fbb.id = post.signature.signature_id.intValue();
                    this.fbb.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fbb.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fbb.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fbb.updateShowInfo();
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
                this.gqQ = post.tpoint_post;
                if (post.agree != null) {
                    this.gqR = true;
                    this.cCv = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.cCt = post.agree.agree_num.longValue();
                    } else {
                        this.cCt = 0L;
                    }
                } else {
                    this.gqR = false;
                }
                this.gqX = post.is_post_visible.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int eZp;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.eZp = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.eZp));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gre;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gre = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0080d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gre != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.gre.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bX(Context context) {
        ArrayList<TbRichTextData> IT;
        if (this.dVS == null || (IT = this.dVS.IT()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = IT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Ja().toString());
            } else if (next.getType() == 17) {
                String str = next.Je().mGifInfo.mSharpText;
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

    public PreLoadImageInfo buL() {
        ArrayList<TbRichTextData> IT;
        if (this.dVS != null && (IT = this.dVS.IT()) != null) {
            Iterator<TbRichTextData> it = IT.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.IZ().getWidth();
                    preLoadImageInfo.height = next.IZ().getHeight();
                    preLoadImageInfo.imgUrl = next.IZ().Jn();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String buM() {
        j buk;
        PreLoadImageInfo buL = buL();
        if (buL != null && !StringUtils.isNull(buL.imgUrl)) {
            return buL.imgUrl;
        }
        if (this.gqJ != null && (buk = this.gqJ.buk()) != null && !StringUtils.isNull(buk.bup())) {
            return buk.bup();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> IT;
        if (this.dVS == null || (IT = this.dVS.IT()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = IT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.IZ().getWidth();
                preLoadImageInfo.height = next.IZ().getHeight();
                preLoadImageInfo.imgUrl = next.IZ().Jn();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.Je() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Je().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Je().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Je();
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
        if (this.gqv == 52) {
            return gqs;
        }
        if (this.gqv == 2) {
            return gqo;
        }
        if (this.gqv == 1) {
            return ZG;
        }
        if (this.gqv == 36) {
            return gqp;
        }
        if (this.gqv == 40 || this.gqv == 50) {
            return Yr;
        }
        if (this.gqv == 41) {
            return gqq;
        }
        if (this.gqv == 53) {
            return gqt;
        }
        if (buG() == 1) {
            return gqm;
        }
        return gqn;
    }

    public void setPostType(int i) {
        this.gqv = i;
    }

    public aq buN() {
        return this.gqC;
    }

    public void a(aq aqVar) {
        this.gqC = aqVar;
    }

    public h buO() {
        return this.gqJ;
    }

    public com.baidu.tbadk.widget.richText.f Jd() {
        if (this.gqN != null) {
            return this.gqN;
        }
        if (this.dVS != null && v.u(this.dVS.IT()) > 0) {
            Iterator<TbRichTextData> it = this.dVS.IT().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gqN = next.Jd();
                    return this.gqN;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Jb() {
        if (this.aoa != null) {
            return this.aoa;
        }
        if (this.dVS != null && v.u(this.dVS.IT()) > 0) {
            Iterator<TbRichTextData> it = this.dVS.IT().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aoa = next.Jb();
                    return this.aoa;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> buP() {
        return this.ZD;
    }

    public String buQ() {
        return this.gqO;
    }

    public String buR() {
        return this.gqP;
    }

    public String sq() {
        return this.ZI;
    }

    public void st() {
        if (this.Zh == 0) {
            this.Zh = 1;
        }
    }

    public long buS() {
        return this.cCt;
    }

    public void cP(long j) {
        this.cCt = j;
    }

    public boolean buT() {
        return this.cCv;
    }

    public void mF(boolean z) {
        this.cCv = z;
    }

    public bc buU() {
        return this.gqK;
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
