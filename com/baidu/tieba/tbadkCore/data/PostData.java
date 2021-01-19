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
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
public class PostData implements com.baidu.adp.widget.ListView.n, ag {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> eMo;
    private OriginalThreadInfo eQQ;
    private SkinInfo eQk;
    private String eQn;
    private Item eRI;
    private TbRichTextVoiceInfo fiM;
    private String lBP;
    private SmallTailInfo lYM;
    public int locate;
    private String nmW;
    public AlaLiveInfoCoreData nnB;
    private boolean nnF;
    public aq nnJ;
    public List<PbContent> nnM;
    private ArrayList<PostData> nna;
    private com.baidu.tbadk.data.c nnh;
    private com.baidu.tbadk.data.g nni;
    private i nnl;
    private bv nnm;
    public boolean nno;
    private com.baidu.tbadk.widget.richText.i nnp;
    private String nnq;
    private String nnr;
    private TPointPost nns;
    public int nnv;
    public boolean nny;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId nmN = BdUniqueId.gen();
    public static final BdUniqueId nmO = BdUniqueId.gen();
    public static final BdUniqueId eQl = BdUniqueId.gen();
    public static final BdUniqueId eOs = BdUniqueId.gen();
    public static final BdUniqueId eOy = BdUniqueId.gen();
    public static final BdUniqueId nmP = BdUniqueId.gen();
    public static final BdUniqueId nmQ = BdUniqueId.gen();
    public static final BdUniqueId nmR = BdUniqueId.gen();
    public static final BdUniqueId nmS = BdUniqueId.gen();
    public static final BdUniqueId nmT = BdUniqueId.gen();
    public static boolean nmU = false;
    private int nmV = 0;
    private boolean nnb = false;
    private ArrayList<PostData> nnc = null;
    private TbRichText nnd = null;
    private boolean nng = false;
    private boolean nnj = false;
    private boolean nnk = false;
    public boolean nnn = false;
    public int ePK = 0;
    private boolean nnt = false;
    public boolean jjz = false;
    public boolean nnu = false;
    public boolean nnw = false;
    public boolean nnx = true;
    public boolean nnz = false;
    public boolean nnA = false;
    private boolean nnC = false;
    private int nnD = 0;
    private boolean nnE = true;
    public boolean nnG = false;
    public boolean nnH = false;
    public boolean nnI = false;
    public boolean nnK = false;
    public boolean nnL = false;
    int nnN = com.baidu.tbadk.a.d.biW();
    private b nnO = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.nnJ != null) {
                aq bst = PostData.this.nnJ.bst();
                bst.delete("obj_locate");
                bst.an("obj_locate", 7);
                TiebaStatic.log(bst);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData ePn = new MetaData();
    private ArrayList<l> nmX = new ArrayList<>();
    private ArrayList<l> nmY = new ArrayList<>();
    private int nmZ = 0;
    private int ePV = 0;
    private PraiseData ePy = new PraiseData();
    private az nne = new az();
    private c nnf = new c();
    private ArrayList<com.baidu.tbadk.data.c> eQh = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.nna = null;
        this.nnv = 0;
        this.nna = new ArrayList<>();
        this.nnv = 0;
    }

    public void xZ(boolean z) {
        this.nnF = z;
    }

    public boolean dLe() {
        return this.nnF;
    }

    public ArrayList<PostData> dLf() {
        return this.nnc;
    }

    public void dLg() {
        this.nnc.clear();
        this.nnc = null;
        this.nnb = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.nnc == null) {
                this.nnc = new ArrayList<>();
                if (x.getCount(this.nna) > this.nnN) {
                    this.nnc.addAll(x.subList(this.nna, 0, this.nnN));
                } else {
                    this.nnc.addAll(this.nna);
                }
            }
            this.nnc.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.nna != null) {
            this.nna.add(postData);
            dLk();
        }
    }

    public void Sh(String str) {
        if (this.nnc != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.nnc.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.nnc.remove(next);
                    return;
                }
            }
        }
    }

    public void ya(boolean z) {
        this.nnE = z;
    }

    public boolean dLh() {
        return this.nnE;
    }

    public void yb(boolean z) {
        this.nnb = z;
    }

    public boolean dLi() {
        return this.nnb;
    }

    public ArrayList<PostData> dLj() {
        return this.nna;
    }

    public void dLk() {
        this.nmZ++;
    }

    public void dLl() {
        this.nmZ--;
    }

    public void Jj(int i) {
        this.nmZ = i;
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

    public int dLm() {
        return this.floor_num;
    }

    public void Jk(int i) {
        this.floor_num = i;
    }

    public boolean dLn() {
        return this.nnk;
    }

    public void yc(boolean z) {
        this.nnk = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData bnx() {
        return this.ePn;
    }

    public void a(MetaData metaData) {
        this.ePn = metaData;
    }

    public void a(PraiseData praiseData) {
        this.ePy = praiseData;
    }

    public TbRichText dLo() {
        return this.nnd;
    }

    public void c(TbRichText tbRichText) {
        this.nnd = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dqX() {
        return this.lYM;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.lYM = smallTailInfo;
    }

    public com.baidu.tbadk.data.g dLp() {
        return this.nni;
    }

    public SkinInfo bnS() {
        return this.eQk;
    }

    public void yd(boolean z) {
        this.nnC = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.nnd != null && this.nnd.bHf() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = null;
            if (z) {
                str = " 楼主";
            } else {
                if (this.ePn != null && this.ePn.getIs_bawu() == 1) {
                    if (this.nnF) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.ePn.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.ePn.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.ePn.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.ePn.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bnx().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mx().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.d.mx().a(next.getIcon(), 21, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.c
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.nnd.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.ePn.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.ePn.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.ePn != null) {
                spannableString = new SpannableString(sb2 + this.ePn.getName_show() + str + "：");
                String userName = this.ePn.getUserName();
                str2 = this.ePn.getUserId();
                str3 = userName;
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.ePn.getSealPrefix())) {
                Bitmap bitmap = ao.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.ePn.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str3, str2, this.nnO), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.ePn != null && this.ePn.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b i3 = i(z, this.ePn != null && this.ePn.getIs_bawu() == 1, str);
                if (i3 != null) {
                    if (this.ePn != null) {
                        int i4 = 0;
                        if (this.ePn.getName_show() != null) {
                            i4 = this.ePn.getName_show().length();
                        }
                        spannableString.setSpan(i3, sb2.length() + i4 + 1, i4 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(i3, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bHf = this.nnd.bHf();
            if (bHf != null && bHf.size() > 0) {
                TbRichTextData tbRichTextData2 = bHf.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bHm() != null) {
                    if (this.nnC) {
                        int indexOf = tbRichTextData2.bHm().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bHm().delete(0, indexOf + 1);
                        }
                        this.nnC = false;
                    }
                    tbRichTextData2.sf(sb.length());
                    tbRichTextData2.bHm().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= bHf.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bHf.get(i6) == null || bHf.get(i6).getType() != 512) {
                            i5 = i6 + 1;
                        } else {
                            TbRichTextVoiceInfo bHn = bHf.get(i6).bHn();
                            bHf.remove(i6);
                            tbRichTextVoiceInfo = bHn;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.sf(sb.length());
                    tbRichTextData.q(spannableString);
                    bHf.add(0, tbRichTextData);
                }
            }
            this.nnG = true;
        }
    }

    private com.baidu.tbadk.core.view.b i(boolean z, boolean z2, String str) {
        if (z || z2) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0302, dimens4, dimens5);
                bVar.pg(dimens2);
                bVar.jT(false);
                bVar.Bh(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.pg(dimens2);
                bVar2.jT(true);
                bVar2.Bh(str);
                return bVar2;
            } else {
                return null;
            }
        }
        return null;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dLq() {
        return this.nmZ;
    }

    public void gS(Context context) {
        int type;
        int i;
        if (this.nmX != null) {
            int i2 = -1;
            int size = this.nmY.size();
            if (size > 0) {
                try {
                    i2 = this.nmY.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.nmX.size()) {
                l lVar = this.nmX.get(i3);
                if (l.dv(i4, lVar.getType())) {
                    this.nmY.get(size - 1).b(lVar.gR(context));
                    i = size;
                    type = i4;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.nmY.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.gR(context));
                        this.nmY.add(lVar2);
                        type = 0;
                    }
                    i = size + 1;
                }
                i3++;
                size = i;
                i4 = type;
            }
        }
    }

    public void gT(Context context) {
        try {
            if (this.nnd != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.nnd.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.nmY == null || this.nmY.size() == 0) {
                gS(context);
            }
            ArrayList<l> arrayList = this.nmY;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dKT() != null) {
                            sb.append((CharSequence) next.dKT());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String Cx = TbFaceManager.bCw().Cx(next.getText());
                        if (Cx != null) {
                            sb.append("[");
                            sb.append(Cx);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dKS())) {
                        sb.append("[").append(next.dKS()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (Exception e) {
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
                this.date = at.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.nnj = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ePn = metaData;
                }
                if (this.ePn.getUserId() == null || this.ePn.getUserId().length() <= 0 || this.ePn.getUserId().equals("0")) {
                    this.ePn = metaData2;
                }
                this.nnd = TbRichTextView.a(context, subPostList.content, z);
                if (this.nnd != null) {
                    this.nnd.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.nmW = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ePn = metaData;
                }
                this.jjz = post.need_log.intValue() == 1;
                this.nnu = post.img_num_abtest.intValue() == 1;
                this.nnm = new bv();
                this.nnm.parserProtobuf(post.from_forum);
                if (this.ePn.getUserId() == null || this.ePn.getUserId().length() <= 0 || this.ePn.getUserId().equals("0")) {
                    this.ePn.parserProtobuf(post.author);
                }
                if (this.ePn != null && context != null) {
                    this.nnq = this.ePn.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.nnr = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.ePn.getLevel_id()));
                }
                this.nng = post.is_ntitle.intValue() == 1;
                this.nmZ = post.sub_post_number.intValue();
                this.nnl = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.nnM = post.content;
                this.nnK = post.is_wonderful_post.intValue() == 1;
                this.nnH = post.is_top_agree_post.intValue() == 1;
                this.eMo = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eRI = post.item;
                }
                this.nnd = TbRichTextView.a(context, list, true);
                if (this.nnd != null) {
                    this.nnd.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.nnd.se(this.floor_num);
                    if (this.ePn != null) {
                        this.nnd.setAuthorId(this.ePn.getUserId());
                    }
                    int count = x.getCount(this.eMo);
                    if (this.floor_num == 1 && count != 0 && this.eMo != null) {
                        ArrayList<TbRichTextData> bHf = this.nnd.bHf();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) x.getItem(bHf, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                x.add(bHf, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) x.getItem(this.eMo, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.r(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eMo.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eMo.get(size);
                                if (headItem2 != null) {
                                    a(bHf, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eRI != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eRI));
                        x.add(this.nnd.bHf(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.nnj = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.xZ(this.nnF);
                            postData.a(subPostList, context);
                            this.nna.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.nnf.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.nnh = new com.baidu.tbadk.data.c();
                    this.nnh.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.nni = new com.baidu.tbadk.data.g();
                    this.nni.a(post.lbs_info);
                }
                this.ePV = post.storecount.intValue();
                this.nne.a(post.present);
                this.ePy.setUserMap(this.userMap);
                this.ePy.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.lYM = new SmallTailInfo();
                    this.lYM.id = post.signature.signature_id.intValue();
                    this.lYM.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.lYM.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.lYM.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.lYM.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eQh.add(cVar);
                    }
                }
                this.eQk = post.skin_info;
                this.eQn = post.lego_card;
                this.nns = post.tpoint_post;
                if (post.agree != null) {
                    this.nnt = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.nnt = false;
                }
                this.nnA = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eQQ = new OriginalThreadInfo();
                    this.eQQ.a(post.origin_thread_info);
                } else {
                    this.eQQ = null;
                }
                this.nnD = post.is_fold.intValue();
                this.lBP = post.fold_tip;
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
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.q(spannableStringBuilder);
        x.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> nnU;
        private b nnV;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.nnU = new SoftReference<>(context);
            this.nnV = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(R.color.CAM_X0108));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.nnU != null && this.nnU.get() != null) {
                if (this.nnV != null) {
                    this.nnV.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.nnU.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String gU(Context context) {
        ArrayList<TbRichTextData> bHf;
        if (this.nnd == null || (bHf = this.nnd.bHf()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bHf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bHm().toString());
            } else if (next.getType() == 17) {
                String str = next.bHq().mGifInfo.mSharpText;
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

    public String dLr() {
        ArrayList<TbRichTextData> bHf;
        String str;
        if (this.nnd == null || (bHf = this.nnd.bHf()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bHf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bHm().toString());
                } else if (next.getType() == 17) {
                    if (next.bHq() != null && next.bHq().mGifInfo != null && (str = next.bHq().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dLs() {
        ArrayList<TbRichTextData> bHf;
        if (this.nnd != null && (bHf = this.nnd.bHf()) != null) {
            Iterator<TbRichTextData> it = bHf.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bHl().getWidth();
                    preLoadImageInfo.height = next.bHl().getHeight();
                    preLoadImageInfo.imgUrl = next.bHl().bHy();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bHr().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bHr().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bHr().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dLt() {
        k dKQ;
        PreLoadImageInfo dLs = dLs();
        if (dLs != null && !StringUtils.isNull(dLs.imgUrl)) {
            return dLs.imgUrl;
        }
        if (this.nnl != null && (dKQ = this.nnl.dKQ()) != null && !StringUtils.isNull(dKQ.dKR())) {
            return dKQ.dKR();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bHf;
        if (this.nnd == null || (bHf = this.nnd.bHf()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bHf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bHl().getWidth();
                preLoadImageInfo.height = next.bHl().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bHl().bHD()) {
                    preLoadImageInfo.imgUrl = next.bHl().bHz();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bHl().bHy();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bHq() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bHq().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bHq().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bHq();
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
        if (this.ePn == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.ePn.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.nmV == 52) {
            return nmR;
        }
        if (this.nmV == 1) {
            return eQl;
        }
        if (this.nmV == 36) {
            return eOs;
        }
        if (this.nmV == 40 || this.nmV == 50) {
            return eOy;
        }
        if (this.nmV == 41) {
            return nmP;
        }
        if (this.nmV == 53) {
            return nmS;
        }
        if (dLm() == 1) {
            return nmN;
        }
        return nmO;
    }

    public void setPostType(int i) {
        this.nmV = i;
    }

    public az dLu() {
        return this.nne;
    }

    public void a(az azVar) {
        this.nne = azVar;
    }

    public i dLv() {
        return this.nnl;
    }

    public com.baidu.tbadk.widget.richText.i bHp() {
        if (this.nnp != null) {
            return this.nnp;
        }
        if (this.nnd != null && x.getCount(this.nnd.bHf()) > 0) {
            Iterator<TbRichTextData> it = this.nnd.bHf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.nnp = next.bHp();
                    return this.nnp;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bHn() {
        if (this.fiM != null) {
            return this.fiM;
        }
        if (this.nnd != null && x.getCount(this.nnd.bHf()) > 0) {
            Iterator<TbRichTextData> it = this.nnd.bHf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.fiM = next.bHn();
                    return this.fiM;
                }
            }
        }
        return null;
    }

    public String dLw() {
        return this.nnq;
    }

    public String boJ() {
        return this.eQn;
    }

    public void boL() {
        if (this.ePK == 0) {
            this.ePK = 1;
        }
    }

    public long boZ() {
        return this.agreeData.disAgreeNum;
    }

    public int bpb() {
        return this.agreeData.agreeType;
    }

    public AgreeData bpr() {
        return this.agreeData;
    }

    public OriginalThreadInfo dLx() {
        return this.eQQ;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eQQ = originalThreadInfo;
    }

    public int dLy() {
        return this.nnD;
    }

    public String diY() {
        return this.lBP;
    }

    public Item bpE() {
        return this.eRI;
    }

    public List<HeadItem> bpF() {
        return this.eMo;
    }
}
