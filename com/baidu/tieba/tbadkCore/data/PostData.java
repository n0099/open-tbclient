package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements q, af {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> dJE;
    private OriginalThreadInfo dNX;
    private SkinInfo dNr;
    private String dNu;
    private Item dOL;
    private TbRichTextVoiceInfo eeA;
    private String jZq;
    private SmallTailInfo kuS;
    private String lFV;
    private ArrayList<PostData> lFZ;
    public AlaLiveInfoCoreData lGA;
    private boolean lGE;
    public ao lGI;
    private com.baidu.tbadk.data.c lGg;
    private com.baidu.tbadk.data.f lGh;
    private i lGk;
    private bq lGl;
    public boolean lGn;
    private com.baidu.tbadk.widget.richText.j lGo;
    private String lGp;
    private String lGq;
    private TPointPost lGr;
    public int lGu;
    public boolean lGx;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId lFL = BdUniqueId.gen();
    public static final BdUniqueId lFM = BdUniqueId.gen();
    public static final BdUniqueId dNs = BdUniqueId.gen();
    public static final BdUniqueId dLC = BdUniqueId.gen();
    public static final BdUniqueId dLH = BdUniqueId.gen();
    public static final BdUniqueId lFN = BdUniqueId.gen();
    public static final BdUniqueId lFO = BdUniqueId.gen();
    public static final BdUniqueId lFP = BdUniqueId.gen();
    public static final BdUniqueId lFQ = BdUniqueId.gen();
    public static final BdUniqueId lFR = BdUniqueId.gen();
    public static boolean lFS = false;
    private int lFT = 0;
    private boolean lGa = false;
    private ArrayList<PostData> lGb = null;
    private TbRichText lGc = null;
    private boolean lGf = false;
    private boolean lGi = false;
    private boolean lGj = false;
    public boolean lGm = false;
    public int dMR = 0;
    private boolean lGs = false;
    public boolean hHE = false;
    public boolean lGt = false;
    public boolean lGv = false;
    public boolean lGw = true;
    public boolean lGy = false;
    public boolean lGz = false;
    private boolean lGB = false;
    private int lGC = 0;
    private boolean lGD = true;
    public boolean lGF = false;
    public boolean lGG = false;
    public boolean lGH = false;
    public boolean lGJ = false;
    public boolean lGK = false;
    private b lGL = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.lGI != null) {
                ao aWM = PostData.this.lGI.aWM();
                aWM.delete("obj_locate");
                aWM.ag("obj_locate", 7);
                TiebaStatic.log(aWM);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int lFU = 0;
    private long time = 0;
    private String date = null;
    private MetaData dMu = new MetaData();
    private ArrayList<l> lFW = new ArrayList<>();
    private ArrayList<l> lFX = new ArrayList<>();
    private int lFY = 0;
    private int dNc = 0;
    private PraiseData dMF = new PraiseData();
    private av lGd = new av();
    private c lGe = new c();
    private ArrayList<com.baidu.tbadk.data.c> dNo = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.lFZ = null;
        this.lGu = 0;
        this.lFZ = new ArrayList<>();
        this.lGu = 0;
    }

    public void uF(boolean z) {
        this.lGE = z;
    }

    public boolean dhR() {
        return this.lGE;
    }

    public ArrayList<PostData> dhS() {
        return this.lGb;
    }

    public void dhT() {
        this.lGb.clear();
        this.lGb = null;
        this.lGa = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.lGb == null) {
                this.lGb = new ArrayList<>();
                if (w.getCount(this.lFZ) > 2) {
                    this.lGb.addAll(w.subList(this.lFZ, 0, 2));
                } else {
                    this.lGb.addAll(this.lFZ);
                }
            }
            this.lGb.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.lFZ != null) {
            this.lFZ.add(postData);
            dhX();
        }
    }

    public void Nf(String str) {
        if (this.lGb != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.lGb.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.lGb.remove(next);
                    return;
                }
            }
        }
    }

    public void uG(boolean z) {
        this.lGD = z;
    }

    public boolean dhU() {
        return this.lGD;
    }

    public void uH(boolean z) {
        this.lGa = z;
    }

    public boolean dhV() {
        return this.lGa;
    }

    public ArrayList<PostData> dhW() {
        return this.lFZ;
    }

    public void dhX() {
        this.lFY++;
    }

    public void dhY() {
        this.lFY--;
    }

    public void EV(int i) {
        this.lFY = i;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dhZ() {
        return this.lFU;
    }

    public void EW(int i) {
        this.lFU = i;
    }

    public boolean dia() {
        return this.lGj;
    }

    public void uI(boolean z) {
        this.lGj = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ar.getFormatTime(j);
    }

    public MetaData aSp() {
        return this.dMu;
    }

    public void a(MetaData metaData) {
        this.dMu = metaData;
    }

    public void a(PraiseData praiseData) {
        this.dMF = praiseData;
    }

    public TbRichText dib() {
        return this.lGc;
    }

    public void c(TbRichText tbRichText) {
        this.lGc = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo cOF() {
        return this.kuS;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.kuS = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dic() {
        return this.lGh;
    }

    public SkinInfo aSL() {
        return this.dNr;
    }

    public void uJ(boolean z) {
        this.lGB = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.lGc != null && this.lGc.bkP() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.dMu != null && this.dMu.getIs_bawu() == 1) {
                    if (this.lGE) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.dMu.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.dMu.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.dMu.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.dMu.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aSp().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.ln().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.ln().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.lGc.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.dMu.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.dMu.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.dMu == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.dMu.getName_show() + str + "：");
                str2 = this.dMu.getUserName();
                str3 = this.dMu.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.dMu.getSealPrefix())) {
                Bitmap bitmap = an.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.dMu.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.lGL), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.dMu != null && this.dMu.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.dMu != null && this.dMu.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.dMu != null) {
                        int i3 = 0;
                        if (this.dMu.getName_show() != null) {
                            i3 = this.dMu.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bkP = this.lGc.bkP();
            if (bkP != null && bkP.size() > 0) {
                TbRichTextData tbRichTextData2 = bkP.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bkW() != null) {
                    if (this.lGB) {
                        int indexOf = tbRichTextData2.bkW().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bkW().delete(0, indexOf + 1);
                        }
                        this.lGB = false;
                    }
                    tbRichTextData2.oK(sb.length());
                    tbRichTextData2.bkW().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bkP.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bkP.get(i5) == null || bkP.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bkX = bkP.get(i5).bkX();
                            bkP.remove(i5);
                            tbRichTextVoiceInfo = bkX;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.oK(sb.length());
                    tbRichTextData.n(spannableString);
                    bkP.add(0, tbRichTextData);
                }
            }
            this.lGF = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.hq(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.ma(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.xf(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int did() {
        return this.lFY;
    }

    public void fo(Context context) {
        int type;
        int i;
        int i2;
        if (this.lFW != null) {
            int i3 = -1;
            int size = this.lFX.size();
            if (size > 0) {
                try {
                    i3 = this.lFX.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.lFW.size()) {
                l lVar = this.lFW.get(i4);
                if (l.db(i5, lVar.getType())) {
                    this.lFX.get(size - 1).b(lVar.fn(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.lFX.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fn(context));
                        this.lFX.add(lVar2);
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

    public void fp(Context context) {
        try {
            if (this.lGc != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.lGc.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.lFX == null || this.lFX.size() == 0) {
                fo(context);
            }
            ArrayList<l> arrayList = this.lFX;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dhJ() != null) {
                            sb.append((CharSequence) next.dhJ());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String yt = TbFaceManager.bgy().yt(next.getText());
                        if (yt != null) {
                            sb.append("[");
                            sb.append(yt);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ar.isEmpty(next.dhI())) {
                        sb.append("[").append(next.dhI()).append("]");
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
                this.lFU = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ar.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.lGi = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dMu = metaData;
                }
                if (this.dMu.getUserId() == null || this.dMu.getUserId().length() <= 0 || this.dMu.getUserId().equals("0")) {
                    this.dMu = metaData2;
                }
                this.lGc = TbRichTextView.a(context, subPostList.content, z);
                if (this.lGc != null) {
                    this.lGc.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.lFU = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ar.getFormatTime(this.time);
                this.lFV = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dMu = metaData;
                }
                this.hHE = post.need_log.intValue() == 1;
                this.lGt = post.img_num_abtest.intValue() == 1;
                this.lGl = new bq();
                this.lGl.parserProtobuf(post.from_forum);
                if (this.dMu.getUserId() == null || this.dMu.getUserId().length() <= 0 || this.dMu.getUserId().equals("0")) {
                    this.dMu.parserProtobuf(post.author);
                }
                if (this.dMu != null && context != null) {
                    this.lGp = this.dMu.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.lGq = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.dMu.getLevel_id()));
                }
                this.lGf = post.is_ntitle.intValue() == 1;
                this.lFY = post.sub_post_number.intValue();
                this.lGk = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.lGJ = post.is_wonderful_post.intValue() == 1;
                this.lGG = post.is_top_agree_post.intValue() == 1;
                this.dJE = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.dOL = post.item;
                }
                this.lGc = TbRichTextView.a(context, list, true);
                if (this.lGc != null) {
                    this.lGc.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.lGc.oJ(this.lFU);
                    if (this.dMu != null) {
                        this.lGc.setAuthorId(this.dMu.getUserId());
                    }
                    if ((this.lGG || this.lGJ) && com.baidu.tbadk.a.d.aNR()) {
                        int i2 = this.lGG ? com.baidu.adp.newwidget.ImageView.b.Qo : com.baidu.adp.newwidget.ImageView.b.Qp;
                        Iterator<TbRichTextData> it = this.lGc.bkP().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            TbRichTextData next = it.next();
                            if (next != null && next.getType() == 1) {
                                next.o(com.baidu.tbadk.widget.richText.e.oN(i2));
                                break;
                            } else if (next != null && next.getType() == 8) {
                                next.oL(i2);
                                break;
                            }
                        }
                    }
                    int count = w.getCount(this.dJE);
                    if (this.lFU == 1 && count != 0 && this.dJE != null) {
                        ArrayList<TbRichTextData> bkP = this.lGc.bkP();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) w.getItem(bkP, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                w.add(bkP, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) w.getItem(this.dJE, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.o(com.baidu.tbadk.widget.richText.e.F(i, false));
                            }
                        } else {
                            for (int size = this.dJE.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.dJE.get(size);
                                if (headItem2 != null) {
                                    a(bkP, headItem2);
                                }
                            }
                        }
                    }
                    if (this.lFU == 1 && this.dOL != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.dOL));
                        w.add(this.lGc.bkP(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            SubPostList subPostList = list2.get(i3);
                            PostData postData = new PostData();
                            postData.lGi = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.uF(this.lGE);
                            postData.a(subPostList, context);
                            this.lFZ.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.lGe.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.lGg = new com.baidu.tbadk.data.c();
                    this.lGg.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.lGh = new com.baidu.tbadk.data.f();
                    this.lGh.a(post.lbs_info);
                }
                this.dNc = post.storecount.intValue();
                this.lGd.a(post.present);
                this.dMF.setUserMap(this.userMap);
                this.dMF.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.kuS = new SmallTailInfo();
                    this.kuS.id = post.signature.signature_id.intValue();
                    this.kuS.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.kuS.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.kuS.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.kuS.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i4 = 0; i4 != post.ext_tails.size(); i4++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i4));
                        this.dNo.add(cVar);
                    }
                }
                this.dNr = post.skin_info;
                this.dNu = post.lego_card;
                this.lGr = post.tpoint_post;
                if (post.agree != null) {
                    this.lGs = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.lGs = false;
                }
                this.lGz = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.dNX = new OriginalThreadInfo();
                    this.dNX.a(post.origin_thread_info);
                } else {
                    this.dNX = null;
                }
                this.lGC = post.is_fold.intValue();
                this.jZq = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.F(i, true));
        }
        tbRichTextData.n(spannableStringBuilder);
        w.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(an.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> lGR;
        private b lGS;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.lGR = new SoftReference<>(context);
            this.lGS = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(an.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.lGR != null && this.lGR.get() != null) {
                if (this.lGS != null) {
                    this.lGS.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lGR.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fq(Context context) {
        ArrayList<TbRichTextData> bkP;
        if (this.lGc == null || (bkP = this.lGc.bkP()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bkP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bkW().toString());
            } else if (next.getType() == 17) {
                String str = next.bla().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String die() {
        ArrayList<TbRichTextData> bkP;
        String str;
        if (this.lGc == null || (bkP = this.lGc.bkP()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bkP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bkW().toString());
                } else if (next.getType() == 17) {
                    if (next.bla() != null && next.bla().mGifInfo != null && (str = next.bla().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dif() {
        ArrayList<TbRichTextData> bkP;
        if (this.lGc != null && (bkP = this.lGc.bkP()) != null) {
            Iterator<TbRichTextData> it = bkP.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bkV().getWidth();
                    preLoadImageInfo.height = next.bkV().getHeight();
                    preLoadImageInfo.imgUrl = next.bkV().blk();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.blb().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.blb().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.blb().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dig() {
        k dhG;
        PreLoadImageInfo dif = dif();
        if (dif != null && !StringUtils.isNull(dif.imgUrl)) {
            return dif.imgUrl;
        }
        if (this.lGk != null && (dhG = this.lGk.dhG()) != null && !StringUtils.isNull(dhG.dhH())) {
            return dhG.dhH();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bkP;
        if (this.lGc == null || (bkP = this.lGc.bkP()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bkP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bkV().getWidth();
                preLoadImageInfo.height = next.bkV().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bkV().blp()) {
                    preLoadImageInfo.imgUrl = next.bkV().bll();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bkV().blk();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bla() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bla().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bla().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bla();
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
        if (this.dMu == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.dMu.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.lFT == 52) {
            return lFP;
        }
        if (this.lFT == 1) {
            return dNs;
        }
        if (this.lFT == 36) {
            return dLC;
        }
        if (this.lFT == 40 || this.lFT == 50) {
            return dLH;
        }
        if (this.lFT == 41) {
            return lFN;
        }
        if (this.lFT == 53) {
            return lFQ;
        }
        if (dhZ() == 1) {
            return lFL;
        }
        return lFM;
    }

    public void setPostType(int i) {
        this.lFT = i;
    }

    public av dih() {
        return this.lGd;
    }

    public void a(av avVar) {
        this.lGd = avVar;
    }

    public i dii() {
        return this.lGk;
    }

    public com.baidu.tbadk.widget.richText.j bkZ() {
        if (this.lGo != null) {
            return this.lGo;
        }
        if (this.lGc != null && w.getCount(this.lGc.bkP()) > 0) {
            Iterator<TbRichTextData> it = this.lGc.bkP().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.lGo = next.bkZ();
                    return this.lGo;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bkX() {
        if (this.eeA != null) {
            return this.eeA;
        }
        if (this.lGc != null && w.getCount(this.lGc.bkP()) > 0) {
            Iterator<TbRichTextData> it = this.lGc.bkP().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.eeA = next.bkX();
                    return this.eeA;
                }
            }
        }
        return null;
    }

    public String dij() {
        return this.lGp;
    }

    public String aTz() {
        return this.dNu;
    }

    public void aTB() {
        if (this.dMR == 0) {
            this.dMR = 1;
        }
    }

    public long aTO() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aUg() {
        return this.agreeData;
    }

    public OriginalThreadInfo dik() {
        return this.dNX;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.dNX = originalThreadInfo;
    }

    public int dil() {
        return this.lGC;
    }

    public String cGZ() {
        return this.jZq;
    }
}
