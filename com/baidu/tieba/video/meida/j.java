package com.baidu.tieba.video.meida;

import androidx.core.internal.view.SupportMenu;
import com.thunder.livesdk.system.ThunderNetStateService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
/* loaded from: classes8.dex */
public class j {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final double[] nPG;
    private static final int[] nPr;
    private static final int[] nPs;
    private static final int[] nPt;
    private static final double[][] nPu;
    private double[] nPA;
    private int nPB;
    private boolean nPC;
    private int nPD;
    private long nPE;
    private long nPF;
    private ByteOrder nPm;
    private k nPn;
    private double nPo;
    private double nPp;
    private int nPq;
    private double[][] nPv;
    private int nPw;
    private int nPx;
    private int nPy;
    private int nPz;

    static {
        $assertionsDisabled = !j.class.desiredAssertionStatus();
        nPr = new int[]{0, 48000, 44100, 37800, 32000, 22050, 48000, 44100};
        nPs = new int[]{1, 16, 20, 16, 16, 15, 16, 15};
        nPt = new int[]{8, 18, 27, 8, 8, 8, 10, 9};
        nPu = new double[][]{new double[]{-1.0d}, new double[]{-2.87207293510437d, 5.041323184967041d, -6.244299411773682d, 5.848398685455322d, -3.706754207611084d, 1.0495119094848633d, 1.1830236911773682d, -2.1126792430877686d, 1.9094531536102295d, -0.9991308450698853d, 0.17090806365013123d, 0.32615602016448975d, -0.39127644896507263d, 0.2687646150588989d, -0.0976761057972908d, 0.023473845794796944d}, new double[]{-2.6773197650909424d, 4.830892562866211d, -6.570110321044922d, 7.4572014808654785d, -6.726327419281006d, 4.848165035247803d, -2.0412089824676514d, -0.7006359100341797d, 2.95375657081604d, -4.080038547515869d, 4.184521675109863d, -3.331181287765503d, 2.117992639541626d, -0.879302978515625d, 0.031759146600961685d, 0.4238278865814209d, -0.4788210391998291d, 0.35490813851356506d, -0.1749683916568756d, 0.06090816855430603d}, new double[]{-1.6335992813110352d, 2.261549234390259d, -2.407702922821045d, 2.634171724319458d, -2.144036293029785d, 1.8153258562088013d, -1.0816224813461304d, 0.703026533126831d, -0.15991993248462677d, -0.04154951870441437d, 0.2941657602787018d, -0.25183168053627014d, 0.27766478061676025d, -0.15785403549671173d, 0.10165894031524658d, -0.016833892092108727d}, new double[]{-0.8290129899978638d, 0.9892265796661377d, -0.5982571244239807d, 1.0028809309005737d, -0.5993821620941162d, 0.7950245141983032d, -0.42723315954208374d, 0.5449252724647522d, -0.3079260587692261d, 0.3687179982662201d, -0.187920480966568d, 0.2261127084493637d, -0.10573341697454453d, 0.11435490846633911d, -0.0388006791472435d, 0.040842197835445404d}, new double[]{-0.06522997468709946d, 0.5498126149177551d, 0.4027854800224304d, 0.3178376853466034d, 0.2820179760456085d, 0.16985194385051727d, 0.15433363616466522d, 0.12507140636444092d, 0.08903945237398148d, 0.06441012024879456d, 0.04714600369334221d, 0.03280523791909218d, 0.028495194390416145d, 0.011695005930960178d, 0.011831838637590408d}, new double[]{-2.3925774097442627d, 3.4350297451019287d, -3.185370922088623d, 1.8117271661758423d, 0.2012477070093155d, -1.4759907722473145d, 1.7210904359817505d, -0.9774670004844666d, 0.13790138065814972d, 0.38185903429985046d, -0.27421241998672485d, -0.06658421456813812d, 0.35223302245140076d, -0.37672343850135803d, 0.23964276909828186d, -0.06867482513189316d}, new double[]{-2.0833916664123535d, 3.0418450832366943d, -3.204789876937866d, 2.757192611694336d, -1.4978630542755127d, 0.34275946021080017d, 0.7173374891281128d, -1.073705792427063d, 1.0225815773010254d, -0.5664999485015869d, 0.20968692004680634d, 0.06537853181362152d, -0.10322438180446625d, 0.06744202226400375d, 0.00495197344571352d}};
        nPG = new double[]{0.7d, 0.9d, 0.18d};
    }

    private int z(double d) {
        return d >= 0.0d ? (int) (d + 0.5d) : (int) (d - 0.5d);
    }

    public int a(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        int[] iArr = new int[97];
        int i7 = 1;
        while (i7 < 6 && i != nPr[i7]) {
            i7++;
        }
        if ((i5 == 3 || i5 == 4) && i7 == 6) {
            System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", Integer.valueOf(i));
        }
        i7 = (i5 == 2 || i7 == 6) ? 0 : 0;
        if (i5 == 4 && (i7 == 1 || i7 == 2)) {
            i7 += 5;
        }
        this.nPw = i7;
        this.nPv = new double[i2];
        this.nPx = nPs[this.nPw];
        for (int i8 = 0; i8 < i2; i8++) {
            this.nPv[i8] = new double[this.nPx];
        }
        this.nPy = i3;
        this.nPz = i4;
        this.nPA = new double[65536];
        Random random = new Random(System.currentTimeMillis());
        for (int i9 = 0; i9 < 97; i9++) {
            iArr[i9] = random.nextInt();
        }
        switch (i6) {
            case 0:
                for (int i10 = 0; i10 < 65536; i10++) {
                    int nextInt = random.nextInt() % 97;
                    int i11 = iArr[nextInt];
                    iArr[nextInt] = random.nextInt();
                    this.nPA[i10] = ((i11 / 2.147483647E9d) - 0.5d) * d;
                }
                break;
            case 1:
                for (int i12 = 0; i12 < 65536; i12++) {
                    int nextInt2 = random.nextInt() % 97;
                    int i13 = iArr[nextInt2];
                    iArr[nextInt2] = random.nextInt();
                    int nextInt3 = random.nextInt() % 97;
                    int i14 = iArr[nextInt3];
                    iArr[nextInt3] = random.nextInt();
                    this.nPA[i12] = ((i13 / 2.147483647E9d) - (i14 / 2.147483647E9d)) * d;
                }
                break;
            case 2:
                boolean z = false;
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (int i15 = 0; i15 < 65536; i15++) {
                    if (!z) {
                        z = true;
                        int nextInt4 = random.nextInt() % 97;
                        double d4 = iArr[nextInt4] / 2.147483647E9d;
                        iArr[nextInt4] = random.nextInt();
                        if (d4 == 1.0d) {
                            d4 = 0.0d;
                        }
                        d2 = Math.sqrt(Math.log(1.0d - d4) * (-2.0d));
                        int nextInt5 = random.nextInt() % 97;
                        iArr[nextInt5] = random.nextInt();
                        d3 = 6.283185307179586d * (iArr[nextInt5] / 2.147483647E9d);
                        this.nPA[i15] = d * d2 * Math.cos(d3);
                    } else {
                        z = false;
                        this.nPA[i15] = d * d2 * Math.sin(d3);
                    }
                }
                break;
        }
        this.nPB = 0;
        if (i5 == 0 || i5 == 1) {
            return 1;
        }
        return nPt[this.nPw];
    }

    public int a(double d, double[] dArr, int i, int i2) {
        double z;
        if (i == 1) {
            double[] dArr2 = this.nPA;
            int i3 = this.nPB;
            this.nPB = i3 + 1;
            double d2 = dArr2[i3 & SupportMenu.USER_MASK] + d;
            if (d2 < this.nPy) {
                double d3 = d2 / this.nPy;
                if (dArr[0] >= d3) {
                    d3 = dArr[0];
                }
                dArr[0] = d3;
                d2 = this.nPy;
            }
            if (d2 > this.nPz) {
                double d4 = d2 / this.nPz;
                if (dArr[0] >= d4) {
                    d4 = dArr[0];
                }
                dArr[0] = d4;
                d2 = this.nPz;
            }
            return z(d2);
        }
        double d5 = 0.0d;
        for (int i4 = 0; i4 < this.nPx; i4++) {
            d5 += nPu[this.nPw][i4] * this.nPv[i2][i4];
        }
        double d6 = d5 + d;
        double[] dArr3 = this.nPA;
        int i5 = this.nPB;
        this.nPB = i5 + 1;
        double d7 = d6 + dArr3[i5 & SupportMenu.USER_MASK];
        for (int i6 = this.nPx - 2; i6 >= 0; i6--) {
            this.nPv[i2][i6 + 1] = this.nPv[i2][i6];
        }
        if (d7 < this.nPy) {
            double d8 = d7 / this.nPy;
            if (dArr[0] >= d8) {
                d8 = dArr[0];
            }
            dArr[0] = d8;
            z = this.nPy;
            this.nPv[i2][0] = z - d6;
            if (this.nPv[i2][0] > 1.0d) {
                this.nPv[i2][0] = 1.0d;
            }
            if (this.nPv[i2][0] < -1.0d) {
                this.nPv[i2][0] = -1.0d;
            }
        } else if (d7 > this.nPz) {
            double d9 = d7 / this.nPz;
            if (dArr[0] >= d9) {
                d9 = dArr[0];
            }
            dArr[0] = d9;
            z = this.nPz;
            this.nPv[i2][0] = z - d6;
            if (this.nPv[i2][0] > 1.0d) {
                this.nPv[i2][0] = 1.0d;
            }
            if (this.nPv[i2][0] < -1.0d) {
                this.nPv[i2][0] = -1.0d;
            }
        } else {
            z = z(d7);
            this.nPv[i2][0] = z - d6;
        }
        return (int) z;
    }

    private void KH(int i) {
    }

    private double A(double d) {
        if (d <= 21.0d) {
            return 0.0d;
        }
        if (d <= 50.0d) {
            return (0.5842d * Math.pow(d - 21.0d, 0.4d)) + (0.07886d * (d - 21.0d));
        }
        return 0.1102d * (d - 8.7d);
    }

    private double a(double d, int i, double d2, double d3) {
        return f.y(Math.sqrt(1.0d - (((4.0d * d) * d) / ((i - 1.0d) * (i - 1.0d)))) * d2) / d3;
    }

    private double B(double d) {
        if (d == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d) / d;
    }

    private double b(int i, double d, double d2) {
        double d3 = 1.0d / d2;
        return B(d3 * 6.283185307179586d * d * i) * 2.0d * d * d3;
    }

    private void dTz() {
        this.nPE = System.currentTimeMillis();
        this.nPF = 0L;
        this.nPD = -1;
    }

    private void C(double d) {
        if (!this.nPC) {
            long currentTimeMillis = System.currentTimeMillis() - this.nPE;
            int i = d == 0.0d ? 0 : (int) ((currentTimeMillis * (1.0d - d)) / d);
            int i2 = (int) (100.0d * d);
            if (i2 != this.nPD || currentTimeMillis != this.nPF) {
                System.err.printf(" %3d%% processed", Integer.valueOf(i2));
                this.nPD = i2;
            }
            if (currentTimeMillis != this.nPF) {
                System.err.printf(", ETA =%4dmsec", Integer.valueOf(i));
                this.nPF = currentTimeMillis;
            }
            System.err.printf("\r", new Object[0]);
            System.err.flush();
        }
    }

    private int gcd(int i, int i2) {
        while (i2 != 0) {
            int i3 = i % i2;
            i = i2;
            i2 = i3;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:233:0x0877, code lost:
        C(1.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0881, code lost:
        return r0[0];
     */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0956  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0963 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d, int i6, boolean z, int i7) throws IOException {
        int i8;
        double d2;
        double d3;
        int i9;
        double d4;
        int z2;
        int z3;
        int z4;
        int i10;
        int i11;
        boolean z5;
        int i12;
        int i13;
        double[] dArr = {0.0d};
        int i14 = 0;
        int i15 = this.nPq;
        double d5 = this.nPo;
        int gcd = gcd(i4, i5);
        int i16 = (i4 / gcd) * i5;
        if (i16 / i5 == 1) {
            i8 = 1;
        } else if ((i16 / i5) % 2 == 0) {
            i8 = 2;
        } else if ((i16 / i5) % 3 == 0) {
            i8 = 3;
        } else {
            throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i16 / i5)));
        }
        double d6 = ((((i5 * i8) / 2) - (i4 / 2)) * 2) / 2.0d;
        double d7 = (i4 / 2) + ((((i5 * i8) / 2) - (i4 / 2)) / 2.0d);
        if (d5 <= 21.0d) {
            d2 = 0.9222d;
        } else {
            d2 = (d5 - 7.95d) / 14.36d;
        }
        int i17 = (int) ((d2 * (i16 / d6)) + 1.0d);
        if (i17 % 2 == 0) {
            i17++;
        }
        double A = A(d5);
        double y = f.y(A);
        int i18 = i16 / i4;
        int i19 = (i17 / i18) + 1;
        int[] iArr = new int[i18 * i8];
        for (int i20 = 0; i20 < i18 * i8; i20++) {
            iArr[i20] = (i16 / i4) - (((i16 / (i5 * i8)) * i20) % (i16 / i4));
            if (iArr[i20] == i16 / i4) {
                iArr[i20] = 0;
            }
        }
        int[] iArr2 = new int[i18 * i8];
        int i21 = 0;
        while (true) {
            int i22 = i21;
            if (i22 >= i18 * i8) {
                break;
            }
            iArr2[i22] = iArr[i22] < i16 / (i5 * i8) ? i : 0;
            if (iArr[i22] == i16 / i4) {
                iArr[i22] = 0;
            }
            i21 = i22 + 1;
        }
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i18, i19);
        for (int i23 = -(i17 / 2); i23 <= i17 / 2; i23++) {
            dArr2[((i17 / 2) + i23) % i18][((i17 / 2) + i23) / i18] = ((a(i23, i17, A, y) * b(i23, d7, i16)) * i16) / i4;
        }
        double d8 = this.nPo;
        if (d8 <= 21.0d) {
            d3 = 0.9222d;
        } else {
            d3 = (d8 - 7.95d) / 14.36d;
        }
        int i24 = i5 * i8;
        int i25 = 1;
        while (true) {
            i9 = i15 * i25;
            if (i9 % 2 == 0) {
                i9--;
            }
            d4 = i4 / 2;
            if ((i24 * d3) / (i9 - 1) < this.nPp) {
                break;
            }
            i25 *= 2;
        }
        double A2 = A(d8);
        double y2 = f.y(A2);
        int i26 = 1;
        while (i26 < i9) {
            i26 *= 2;
        }
        int i27 = i26 * 2;
        double[] dArr3 = new double[i27];
        int i28 = -(i9 / 2);
        while (i28 <= i9 / 2) {
            dArr3[(i9 / 2) + i28] = ((a(i28, i9, A2, y2) * b(i28, d4, i24)) / i27) * 2.0d;
            i28++;
        }
        int[] iArr3 = new int[(int) (2.0d + Math.sqrt(i27))];
        iArr3[0] = 0;
        double[] dArr4 = new double[i27 / 2];
        this.nPn.a(i27, 1, dArr3, iArr3, dArr4);
        dTz();
        int i29 = i27 / 2;
        int i30 = 0;
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, i, (i29 / i8) + 1);
        double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i, i27);
        ByteBuffer allocate = ByteBuffer.allocate((i29 + i19 + 2) * i * i2);
        ByteBuffer allocate2 = ByteBuffer.allocate(((i29 / i8) + 1) * i * i3);
        double[] dArr7 = new double[(i29 + i19 + 2) * i];
        double[] dArr8 = new double[((i29 / i8) + 1) * i];
        int i31 = ((i17 / 2) / (i16 / i4)) + 1;
        int i32 = (int) ((i9 / 2.0d) / (i24 / i5));
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        boolean z6 = true;
        int i36 = 0;
        int i37 = 0;
        int i38 = i28;
        ByteBuffer byteBuffer = allocate;
        while (true) {
            int ceil = (int) (((Math.ceil((i29 * i4) / (i5 * i8)) + 1.0d) + i19) - i31);
            int i39 = ceil + i35 > i6 ? i6 - i35 : ceil;
            byteBuffer.position(0);
            byteBuffer.limit(i39 * i2 * i);
            byte[] bArr = new byte[byteBuffer.limit()];
            int read = inputStream.read(bArr);
            if (read < 0) {
                read = 0;
            }
            if (read < byteBuffer.limit()) {
                i6 = i35 + ((read / i2) * i);
            }
            byteBuffer.limit(read);
            byteBuffer = ByteBuffer.wrap(bArr);
            byteBuffer.position(read);
            byteBuffer.flip();
            int i40 = read / (i2 * i);
            switch (i2) {
                case 1:
                    i38 = 0;
                    while (i38 < i40 * i) {
                        dArr7[(i * i31) + i38] = 0.007874015748031496d * (byteBuffer.get(i38) - 128.0d);
                        i38++;
                    }
                    break;
                case 2:
                    i38 = 0;
                    while (i38 < i40 * i) {
                        dArr7[(i * i31) + i38] = 3.051850947599719E-5d * byteBuffer.order(this.nPm).asShortBuffer().get(i38);
                        i38++;
                    }
                    break;
                case 3:
                    i38 = 0;
                    while (i38 < i40 * i) {
                        dArr7[(i * i31) + i38] = 1.1920930376163766E-7d * ((byteBuffer.get(i38 * 3) << 0) | (byteBuffer.get((i38 * 3) + 1) << 8) | (byteBuffer.get((i38 * 3) + 2) << 16));
                        i38++;
                    }
                    break;
                case 4:
                    i38 = 0;
                    while (i38 < i40 * i) {
                        dArr7[(i * i31) + i38] = 4.656612875245797E-10d * byteBuffer.order(this.nPm).asIntBuffer().get(i38);
                        i38++;
                    }
                    break;
            }
            while (i38 < i * ceil) {
                dArr7[(i * i31) + i38] = 0.0d;
                i38++;
            }
            int i41 = i31 + ceil;
            int i42 = i35 + i40;
            boolean z7 = i42 >= i6;
            int i43 = ((((i37 - 1) * i4) + i16) / i16) * i;
            int i44 = 0;
            int i45 = i33;
            int i46 = i36;
            while (i44 < i) {
                int i47 = i18 * i8;
                int i48 = i43 + i44;
                switch (i19) {
                    case 7:
                        i13 = i36;
                        for (int i49 = 0; i49 < i29; i49++) {
                            int i50 = iArr[i13];
                            dArr6[i44][i49] = (dArr2[i50][0] * dArr7[(i * 0) + i48]) + (dArr2[i50][1] * dArr7[(i * 1) + i48]) + (dArr2[i50][2] * dArr7[(i * 2) + i48]) + (dArr2[i50][3] * dArr7[(i * 3) + i48]) + (dArr2[i50][4] * dArr7[(i * 4) + i48]) + (dArr2[i50][5] * dArr7[(i * 5) + i48]) + (dArr2[i50][6] * dArr7[(i * 6) + i48]);
                            i48 += iArr2[i13];
                            i13++;
                            if (i13 == i47) {
                                i13 = 0;
                            }
                        }
                        break;
                    case 8:
                    default:
                        i13 = i36;
                        for (int i51 = 0; i51 < i29; i51++) {
                            double d9 = 0.0d;
                            int i52 = iArr[i13];
                            int i53 = i48;
                            for (int i54 = 0; i54 < i19; i54++) {
                                d9 += dArr2[i52][i54] * dArr7[i53];
                                i53 += i;
                            }
                            dArr6[i44][i51] = d9;
                            i48 += iArr2[i13];
                            i13++;
                            if (i13 == i47) {
                                i13 = 0;
                            }
                        }
                        break;
                    case 9:
                        i13 = i36;
                        for (int i55 = 0; i55 < i29; i55++) {
                            int i56 = iArr[i13];
                            dArr6[i44][i55] = (dArr2[i56][0] * dArr7[(i * 0) + i48]) + (dArr2[i56][1] * dArr7[(i * 1) + i48]) + (dArr2[i56][2] * dArr7[(i * 2) + i48]) + (dArr2[i56][3] * dArr7[(i * 3) + i48]) + (dArr2[i56][4] * dArr7[(i * 4) + i48]) + (dArr2[i56][5] * dArr7[(i * 5) + i48]) + (dArr2[i56][6] * dArr7[(i * 6) + i48]) + (dArr2[i56][7] * dArr7[(i * 7) + i48]) + (dArr2[i56][8] * dArr7[(i * 8) + i48]);
                            i48 += iArr2[i13];
                            i13++;
                            if (i13 == i47) {
                                i13 = 0;
                            }
                        }
                        break;
                }
                for (int i57 = i29; i57 < i27; i57++) {
                    dArr6[i44][i57] = 0.0d;
                }
                this.nPn.a(i27, 1, dArr6[i44], iArr3, dArr4);
                dArr6[i44][0] = dArr3[0] * dArr6[i44][0];
                dArr6[i44][1] = dArr3[1] * dArr6[i44][1];
                for (int i58 = 1; i58 < i27 / 2; i58++) {
                    dArr6[i44][i58 * 2] = (dArr3[i58 * 2] * dArr6[i44][i58 * 2]) - (dArr3[(i58 * 2) + 1] * dArr6[i44][(i58 * 2) + 1]);
                    dArr6[i44][(i58 * 2) + 1] = (dArr3[(i58 * 2) + 1] * dArr6[i44][i58 * 2]) + (dArr3[i58 * 2] * dArr6[i44][(i58 * 2) + 1]);
                }
                this.nPn.a(i27, -1, dArr6[i44], iArr3, dArr4);
                int i59 = 0;
                int i60 = i33;
                while (i60 < i29) {
                    dArr8[(i59 * i) + i44] = dArr5[i44][i59] + dArr6[i44][i60];
                    i60 += i8;
                    i59++;
                }
                i45 = i60 - i29;
                int i61 = 0;
                while (i60 < i27) {
                    dArr5[i44][i61] = dArr6[i44][i60];
                    i60 += i8;
                    i61++;
                }
                i44++;
                i46 = i13;
                i30 = i59;
                i38 = i60;
            }
            int i62 = i37 + (((i4 / gcd) * i29) / i8);
            allocate2.clear();
            if (z) {
                i38 = 0;
                while (i38 < i30 * i) {
                    double d10 = dArr8[i38] > 0.0d ? dArr8[i38] : -dArr8[i38];
                    if (dArr[0] >= d10) {
                        d10 = dArr[0];
                    }
                    dArr[0] = d10;
                    allocate2.asDoubleBuffer().put(i38, dArr8[i38]);
                    i38++;
                }
            } else {
                switch (i3) {
                    case 1:
                        double d11 = d * 127.0d;
                        int i63 = 0;
                        i38 = 0;
                        while (i38 < i30 * i) {
                            if (i7 != 0) {
                                z4 = a(dArr8[i38] * d11, dArr, i7, i63);
                            } else {
                                z4 = z(dArr8[i38] * d11);
                                if (z4 < -128) {
                                    double d12 = z4 / (-128.0d);
                                    if (dArr[0] >= d12) {
                                        d12 = dArr[0];
                                    }
                                    dArr[0] = d12;
                                    z4 = -128;
                                }
                                if (127 < z4) {
                                    double d13 = z4 / 127.0d;
                                    if (dArr[0] >= d13) {
                                        d13 = dArr[0];
                                    }
                                    dArr[0] = d13;
                                    z4 = ThunderNetStateService.NetState.SYSNET_UNKNOWN;
                                }
                            }
                            allocate2.put(i38, (byte) (z4 + 128));
                            int i64 = i63 + 1;
                            if (i64 == i) {
                                i64 = 0;
                            }
                            i38++;
                            i63 = i64;
                        }
                        break;
                    case 2:
                        double d14 = d * 32767.0d;
                        int i65 = 0;
                        i38 = 0;
                        while (i38 < i30 * i) {
                            if (i7 != 0) {
                                z3 = a(dArr8[i38] * d14, dArr, i7, i65);
                            } else {
                                z3 = z(dArr8[i38] * d14);
                                if (z3 < -32768) {
                                    double d15 = z3 / (-32768.0d);
                                    if (dArr[0] >= d15) {
                                        d15 = dArr[0];
                                    }
                                    dArr[0] = d15;
                                    z3 = -32768;
                                }
                                if (32767 < z3) {
                                    double d16 = z3 / 32767.0d;
                                    if (dArr[0] >= d16) {
                                        d16 = dArr[0];
                                    }
                                    dArr[0] = d16;
                                    z3 = 32767;
                                }
                            }
                            allocate2.order(this.nPm).asShortBuffer().put(i38, (short) z3);
                            int i66 = i65 + 1;
                            if (i66 == i) {
                                i66 = 0;
                            }
                            i38++;
                            i65 = i66;
                        }
                        break;
                    case 3:
                        double d17 = d * 8388607.0d;
                        int i67 = 0;
                        i38 = 0;
                        while (i38 < i30 * i) {
                            if (i7 != 0) {
                                z2 = a(dArr8[i38] * d17, dArr, i7, i67);
                            } else {
                                z2 = z(dArr8[i38] * d17);
                                if (z2 < -8388608) {
                                    double d18 = z2 / (-8388608.0d);
                                    if (dArr[0] >= d18) {
                                        d18 = dArr[0];
                                    }
                                    dArr[0] = d18;
                                    z2 = -8388608;
                                }
                                if (8388607 < z2) {
                                    double d19 = z2 / 8388607.0d;
                                    if (dArr[0] >= d19) {
                                        d19 = dArr[0];
                                    }
                                    dArr[0] = d19;
                                    z2 = 8388607;
                                }
                            }
                            allocate2.put(i38 * 3, (byte) (z2 & 255));
                            int i68 = z2 >> 8;
                            allocate2.put((i38 * 3) + 1, (byte) (i68 & 255));
                            allocate2.put((i38 * 3) + 2, (byte) ((i68 >> 8) & 255));
                            int i69 = i67 + 1;
                            if (i69 == i) {
                                i69 = 0;
                            }
                            i38++;
                            i67 = i69;
                        }
                        break;
                }
            }
            if (!z6) {
                if (z7) {
                    if (((i42 * i5) / i4) + 2.0d > i34 + i30) {
                        allocate2.position(0);
                        allocate2.limit(i3 * i * i30);
                        a(outputStream, allocate2);
                        i10 = i34 + i30;
                        i11 = i32;
                        z5 = z6;
                    } else {
                        allocate2.position(0);
                        int floor = (int) (i3 * i * ((Math.floor((i42 * i5) / i4) + 2.0d) - i34));
                        if (floor > 0) {
                            allocate2.limit(floor);
                            a(outputStream, allocate2);
                        }
                    }
                } else {
                    allocate2.position(0);
                    allocate2.limit(i3 * i * i30);
                    a(outputStream, allocate2);
                    i10 = i34 + i30;
                    i11 = i32;
                    z5 = z6;
                }
                i12 = (i62 - 1) / (i16 / i4);
                if ($assertionsDisabled && i41 < i12) {
                    throw new AssertionError();
                }
                System.arraycopy(dArr7, i * i12, dArr7, 0, (i41 - i12) * i);
                i31 = i41 - i12;
                int i70 = i62 - (i12 * (i16 / i4));
                int i71 = i14 + 1;
                if ((i14 & 7) != 7) {
                    C(i42 / i6);
                }
                i32 = i11;
                i33 = i45;
                i34 = i10;
                i35 = i42;
                z6 = z5;
                i36 = i46;
                i37 = i70;
                i14 = i71;
            } else {
                if (i30 < i32) {
                    i11 = i32 - i30;
                    i10 = i34;
                    z5 = z6;
                } else if (z7) {
                    if (((i42 * i5) / i4) + 2.0d > (i34 + i30) - i32) {
                        allocate2.position(i3 * i * i32);
                        allocate2.limit(i3 * i * i30);
                        a(outputStream, allocate2);
                        i10 = i34 + (i30 - i32);
                        i11 = i32;
                        z5 = z6;
                    } else {
                        allocate2.position(i3 * i * i32);
                        allocate2.limit((int) (i3 * i * ((Math.floor((i42 * i5) / i4) + 2.0d) - i34)));
                        a(outputStream, allocate2);
                    }
                } else {
                    allocate2.position(i3 * i * i32);
                    allocate2.limit(i3 * i * i30);
                    a(outputStream, allocate2);
                    i10 = i34 + (i30 - i32);
                    i11 = i32;
                    z5 = false;
                }
                i12 = (i62 - 1) / (i16 / i4);
                if ($assertionsDisabled) {
                }
                System.arraycopy(dArr7, i * i12, dArr7, 0, (i41 - i12) * i);
                i31 = i41 - i12;
                int i702 = i62 - (i12 * (i16 / i4));
                int i712 = i14 + 1;
                if ((i14 & 7) != 7) {
                }
                i32 = i11;
                i33 = i45;
                i34 = i10;
                i35 = i42;
                z6 = z5;
                i36 = i46;
                i37 = i702;
                i14 = i712;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:248:0x0860, code lost:
        C(1.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x086a, code lost:
        return r0[0];
     */
    /* JADX WARN: Removed duplicated region for block: B:177:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0696 A[LOOP:18: B:179:0x0692->B:181:0x0696, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x093b A[LOOP:19: B:261:0x0937->B:263:0x093b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0963 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double b(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, double d, int i6, boolean z, int i7) throws IOException {
        int i8;
        double d2;
        int i9;
        double d3;
        double d4;
        int[] iArr;
        int[] iArr2;
        int i10;
        int i11;
        int i12;
        double[][] dArr;
        int i13;
        int z2;
        int z3;
        int z4;
        int i14;
        boolean z5;
        int i15;
        int i16;
        int i17;
        int i18;
        double[] dArr2 = {0.0d};
        int i19 = this.nPq;
        double d5 = this.nPo;
        int gcd = gcd(i4, i5);
        if (i5 / gcd == 1) {
            i8 = 1;
        } else if ((i5 / gcd) % 2 == 0) {
            i8 = 2;
        } else if ((i5 / gcd) % 3 == 0) {
            i8 = 3;
        } else {
            throw new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i5 / gcd)));
        }
        int i20 = i4 * i8;
        if (d5 <= 21.0d) {
            d2 = 0.9222d;
        } else {
            d2 = (d5 - 7.95d) / 14.36d;
        }
        int i21 = 1;
        while (true) {
            i9 = i19 * i21;
            if (i9 % 2 == 0) {
                i9--;
            }
            double d6 = (i20 * d2) / (i9 - 1);
            d3 = (i5 - d6) / 2.0d;
            if (d6 < this.nPp) {
                break;
            }
            i21 *= 2;
        }
        double A = A(d5);
        double y = f.y(A);
        int i22 = 1;
        while (i22 < i9) {
            i22 *= 2;
        }
        int i23 = i22 * 2;
        double[] dArr3 = new double[i23];
        int i24 = -(i9 / 2);
        while (i24 <= i9 / 2) {
            dArr3[i24 + (i9 / 2)] = ((((a(i24, i9, A, y) * b(i24, d3, i20)) * i20) / i4) / i23) * 2.0d;
            i24++;
        }
        int[] iArr3 = new int[(int) (2.0d + Math.sqrt(i23))];
        iArr3[0] = 0;
        double[] dArr4 = new double[i23 / 2];
        this.nPn.a(i23, 1, dArr3, iArr3, dArr4);
        if (i8 == 1) {
            int i25 = (i4 / gcd) * i5;
            double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, 1, 1);
            dArr5[0][0] = 1.0d;
            iArr = new int[]{i4 / i5};
            iArr2 = new int[]{0};
            i10 = 1;
            i11 = 1;
            i12 = 1;
            dArr = dArr5;
            i13 = i25;
        } else {
            double d7 = this.nPo;
            int i26 = (i4 / gcd) * i5;
            double d8 = (((i20 / 2) - (i4 / 2)) * 2) / 2.0d;
            double d9 = (i4 / 2) + (((i20 / 2) - (i4 / 2)) / 2.0d);
            if (d7 <= 21.0d) {
                d4 = 0.9222d;
            } else {
                d4 = (d7 - 7.95d) / 14.36d;
            }
            int i27 = (int) ((d4 * (i26 / d8)) + 1.0d);
            if (i27 % 2 == 0) {
                i27++;
            }
            double A2 = A(d7);
            double y2 = f.y(A2);
            int i28 = i26 / i20;
            int i29 = (i27 / i28) + 1;
            int[] iArr4 = new int[i28];
            for (int i30 = 0; i30 < i28; i30++) {
                iArr4[i30] = (i26 / i20) - (((i26 / i5) * i30) % (i26 / i20));
                if (iArr4[i30] == i26 / i20) {
                    iArr4[i30] = 0;
                }
            }
            int[] iArr5 = new int[i28];
            int i31 = 0;
            while (true) {
                int i32 = i31;
                if (i32 >= i28) {
                    break;
                }
                iArr5[i32] = (((i26 / i5) - iArr4[i32]) / (i26 / i20)) + 1;
                if (iArr4[i32 + 1 == i28 ? 0 : i32 + 1] == 0) {
                    iArr5[i32] = iArr5[i32] - 1;
                }
                i31 = i32 + 1;
            }
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i28, i29);
            int i33 = -(i27 / 2);
            while (i33 <= i27 / 2) {
                dArr6[((i27 / 2) + i33) % i28][((i27 / 2) + i33) / i28] = ((a(i33, i27, A2, y2) * b(i33, d9, i26)) * i26) / i20;
                i33++;
            }
            i24 = i33;
            iArr = iArr5;
            iArr2 = iArr4;
            i10 = i28;
            i11 = i29;
            i12 = i27;
            dArr = dArr6;
            i13 = i26;
        }
        dTz();
        int i34 = i23 / 2;
        double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, i, i23);
        double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, i, i11 + 1 + i34);
        ByteBuffer allocate = ByteBuffer.allocate(((i34 / i8) + i8 + 1) * i * i2);
        ByteBuffer allocate2 = ByteBuffer.allocate((int) ((((i34 * i5) / i4) + 1.0d) * i3 * i));
        double[] dArr9 = new double[((i34 / i8) + i8 + 1) * i];
        double[] dArr10 = new double[(int) (i * (((i34 * i5) / i4) + 1.0d))];
        int i35 = 0;
        boolean z6 = true;
        int i36 = (int) (((i9 / 2.0d) / (i20 / i5)) + ((i12 / 2.0d) / (i13 / i5)));
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = i24;
        ByteBuffer byteBuffer = allocate;
        while (true) {
            int i44 = (((i34 - 0) - 1) / i8) + 1;
            if (i44 + i38 > i6) {
                i44 = i6 - i38;
            }
            byteBuffer.position(0);
            byteBuffer.limit(i2 * i * i44);
            byte[] bArr = new byte[byteBuffer.limit()];
            int read = inputStream.read(bArr);
            if (read < 0) {
                read = 0;
            }
            if (read < byteBuffer.limit()) {
                i6 = i38 + ((read / i2) * i);
            }
            byteBuffer.limit(read);
            byteBuffer = ByteBuffer.wrap(bArr);
            byteBuffer.position(read);
            byteBuffer.flip();
            int i45 = read / (i2 * i);
            switch (i2) {
                case 1:
                    i43 = 0;
                    while (i43 < i45 * i) {
                        dArr9[(i * 0) + i43] = 0.007874015748031496d * ((byteBuffer.get(i43) & 255) - 128);
                        i43++;
                    }
                    break;
                case 2:
                    i43 = 0;
                    while (i43 < i45 * i) {
                        dArr9[(i * 0) + i43] = 3.051850947599719E-5d * byteBuffer.order(this.nPm).asShortBuffer().get(i43);
                        i43++;
                    }
                    break;
                case 3:
                    i43 = 0;
                    while (i43 < i45 * i) {
                        dArr9[(i * 0) + i43] = 1.1920930376163766E-7d * (((byteBuffer.get(i43 * 3) & 255) << 0) | ((byteBuffer.get((i43 * 3) + 1) & 255) << 8) | ((byteBuffer.get((i43 * 3) + 2) & 255) << 16));
                        i43++;
                    }
                    break;
                case 4:
                    i43 = 0;
                    while (i43 < i45 * i) {
                        dArr9[(i * 0) + i43] = 4.656612875245797E-10d * byteBuffer.order(this.nPm).getInt(i43);
                        i43++;
                    }
                    break;
            }
            while (i43 < i * i44) {
                dArr9[i43] = 0.0d;
                i43++;
            }
            int i46 = i38 + i45;
            boolean z7 = inputStream.available() < 0 || i46 >= i6;
            int i47 = 0;
            int i48 = i35;
            int i49 = i39;
            while (i47 < i) {
                int i50 = 0;
                int i51 = 0;
                while (i51 < i34) {
                    if (!$assertionsDisabled && i50 >= (((i34 - 0) - 1) / i8) + 1) {
                        throw new AssertionError();
                    }
                    dArr7[i47][i51] = dArr9[(i50 * i) + i47];
                    for (int i52 = i51 + 1; i52 < i51 + i8; i52++) {
                        dArr7[i47][i52] = 0.0d;
                    }
                    i51 += i8;
                    i50++;
                }
                if (!$assertionsDisabled && i50 != (((i34 - 0) - 1) / i8) + 1) {
                    throw new AssertionError();
                }
                for (int i53 = i34; i53 < i23; i53++) {
                    dArr7[i47][i53] = 0.0d;
                }
                int i54 = i51 - i34;
                int i55 = i41 + i50;
                this.nPn.a(i23, 1, dArr7[i47], iArr3, dArr4);
                dArr7[i47][0] = dArr3[0] * dArr7[i47][0];
                dArr7[i47][1] = dArr3[1] * dArr7[i47][1];
                for (int i56 = 1; i56 < i34; i56++) {
                    double d10 = (dArr3[i56 * 2] * dArr7[i47][i56 * 2]) - (dArr3[(i56 * 2) + 1] * dArr7[i47][(i56 * 2) + 1]);
                    double d11 = (dArr3[(i56 * 2) + 1] * dArr7[i47][i56 * 2]) + (dArr3[i56 * 2] * dArr7[i47][(i56 * 2) + 1]);
                    dArr7[i47][i56 * 2] = d10;
                    dArr7[i47][(i56 * 2) + 1] = d11;
                }
                this.nPn.a(i23, -1, dArr7[i47], iArr3, dArr4);
                int i57 = 0;
                while (i57 < i34) {
                    double[] dArr11 = dArr8[i47];
                    int i58 = i11 + 1 + i57;
                    dArr11[i58] = dArr11[i58] + dArr7[i47][i57];
                    i57++;
                }
                int i59 = i40 / (i13 / i20);
                if (i40 % (i13 / i20) != 0) {
                    i59++;
                }
                int length = (dArr8[0].length * i47) + i59;
                int i60 = 0;
                int i61 = i35;
                int i62 = i57;
                while (length - (dArr8[0].length * i47) < i34 + 1) {
                    double d12 = 0.0d;
                    int i63 = iArr2[i61];
                    int i64 = length + iArr[i61];
                    int i65 = i61 + 1;
                    if (i65 == i10) {
                        i65 = 0;
                    }
                    if (!$assertionsDisabled && ((length - (dArr8[0].length * i47)) * (i13 / i20)) - (((i13 / i5) * i60) + i40) != i63) {
                        throw new AssertionError();
                    }
                    i62 = 0;
                    while (i62 < i11) {
                        d12 += dArr[i63][i62] * dArr8[length / dArr8[0].length][length % dArr8[0].length];
                        length++;
                        i62++;
                    }
                    dArr10[(i60 * i) + 0 + i47] = d12;
                    i60++;
                    length = i64;
                    i61 = i65;
                }
                i47++;
                i48 = i61;
                i49 = i60;
                i41 = i55;
                i43 = i62;
            }
            int i66 = i40 + ((i13 / i5) * i49);
            allocate2.clear();
            if (z) {
                i43 = 0;
                while (i43 < i49 * i) {
                    double d13 = dArr10[i43] > 0.0d ? dArr10[i43] : -dArr10[i43];
                    if (dArr2[0] >= d13) {
                        d13 = dArr2[0];
                    }
                    dArr2[0] = d13;
                    allocate2.asDoubleBuffer().put(i43, dArr10[i43]);
                    i43++;
                }
            } else {
                switch (i3) {
                    case 1:
                        double d14 = d * 127.0d;
                        int i67 = 0;
                        i43 = 0;
                        while (i43 < i49 * i) {
                            if (i7 != 0) {
                                z4 = a(dArr10[i43] * d14, dArr2, i7, i67);
                            } else {
                                z4 = z(dArr10[i43] * d14);
                                if (z4 < -128) {
                                    double d15 = z4 / (-128.0d);
                                    if (dArr2[0] >= d15) {
                                        d15 = dArr2[0];
                                    }
                                    dArr2[0] = d15;
                                    z4 = -128;
                                }
                                if (127 < z4) {
                                    double d16 = z4 / 127.0d;
                                    if (dArr2[0] >= d16) {
                                        d16 = dArr2[0];
                                    }
                                    dArr2[0] = d16;
                                    z4 = ThunderNetStateService.NetState.SYSNET_UNKNOWN;
                                }
                            }
                            allocate2.put(i43, (byte) (z4 + 128));
                            int i68 = i67 + 1;
                            if (i68 == i) {
                                i68 = 0;
                            }
                            i43++;
                            i67 = i68;
                        }
                        break;
                    case 2:
                        double d17 = d * 32767.0d;
                        int i69 = 0;
                        i43 = 0;
                        while (i43 < i49 * i) {
                            if (i7 != 0) {
                                z3 = a(dArr10[i43] * d17, dArr2, i7, i69);
                            } else {
                                z3 = z(dArr10[i43] * d17);
                                if (z3 < -32768) {
                                    double d18 = z3 / (-32768.0d);
                                    if (dArr2[0] >= d18) {
                                        d18 = dArr2[0];
                                    }
                                    dArr2[0] = d18;
                                    z3 = -32768;
                                }
                                if (32767 < z3) {
                                    double d19 = z3 / 32767.0d;
                                    if (dArr2[0] >= d19) {
                                        d19 = dArr2[0];
                                    }
                                    dArr2[0] = d19;
                                    z3 = 32767;
                                }
                            }
                            allocate2.order(this.nPm).asShortBuffer().put(i43, (short) z3);
                            int i70 = i69 + 1;
                            if (i70 == i) {
                                i70 = 0;
                            }
                            i43++;
                            i69 = i70;
                        }
                        break;
                    case 3:
                        double d20 = d * 8388607.0d;
                        int i71 = 0;
                        i43 = 0;
                        while (i43 < i49 * i) {
                            if (i7 != 0) {
                                z2 = a(dArr10[i43] * d20, dArr2, i7, i71);
                            } else {
                                z2 = z(dArr10[i43] * d20);
                                if (z2 < -8388608) {
                                    double d21 = z2 / (-8388608.0d);
                                    if (dArr2[0] >= d21) {
                                        d21 = dArr2[0];
                                    }
                                    dArr2[0] = d21;
                                    z2 = -8388608;
                                }
                                if (8388607 < z2) {
                                    double d22 = z2 / 8388607.0d;
                                    if (dArr2[0] >= d22) {
                                        d22 = dArr2[0];
                                    }
                                    dArr2[0] = d22;
                                    z2 = 8388607;
                                }
                            }
                            allocate2.put(i43 * 3, (byte) (z2 & 255));
                            int i72 = z2 >> 8;
                            allocate2.put((i43 * 3) + 1, (byte) (i72 & 255));
                            allocate2.put((i43 * 3) + 2, (byte) ((i72 >> 8) & 255));
                            int i73 = i71 + 1;
                            if (i73 == i) {
                                i73 = 0;
                            }
                            i43++;
                            i71 = i73;
                        }
                        break;
                }
            }
            if (!z6) {
                if (z7) {
                    if (((i46 * i5) / i4) + 2.0d > i37 + i49) {
                        allocate2.position(0);
                        allocate2.limit(i3 * i * i49);
                        a(outputStream, allocate2);
                        i14 = i37 + i49;
                        i15 = i36;
                        z5 = z6;
                    } else {
                        allocate2.position(0);
                        int floor = (int) (i3 * i * ((Math.floor((i46 * i5) / i4) + 2.0d) - i37));
                        if (floor > 0) {
                            allocate2.limit(floor);
                            a(outputStream, allocate2);
                        }
                    }
                } else {
                    allocate2.position(0);
                    allocate2.limit(i3 * i * i49);
                    a(outputStream, allocate2);
                    i14 = i37 + i49;
                    i15 = i36;
                    z5 = z6;
                }
                i16 = (i66 - 1) / (i13 / i20);
                if (i16 > i34) {
                    i16 = i34;
                }
                for (i17 = 0; i17 < i; i17++) {
                    System.arraycopy(dArr8[i17], i16, dArr8[i17], 0, ((i11 + 1) + i34) - i16);
                }
                int i74 = i66 - (i16 * (i13 / i20));
                for (i18 = 0; i18 < i; i18++) {
                    System.arraycopy(dArr7[i18], i34, dArr8[i18], i11 + 1, i34);
                }
                int i75 = i42 + 1;
                if ((i42 & 7) != 7) {
                    C(i46 / i6);
                }
                i36 = i15;
                i37 = i14;
                i38 = i46;
                z6 = z5;
                i35 = i48;
                i39 = i49;
                i40 = i74;
                i42 = i75;
            } else {
                if (i49 < i36) {
                    i15 = i36 - i49;
                    i14 = i37;
                    z5 = z6;
                } else if (z7) {
                    if (((i46 * i5) / i4) + 2.0d > (i37 + i49) - i36) {
                        allocate2.position(i3 * i * i36);
                        allocate2.limit(i3 * i * (i49 - i36));
                        a(outputStream, allocate2);
                        i14 = i37 + (i49 - i36);
                        i15 = i36;
                        z5 = z6;
                    } else {
                        allocate2.position(i3 * i * i36);
                        allocate2.limit((int) (i3 * i * ((((Math.floor((i46 * i5) / i4) + 2.0d) + i37) + i49) - i36)));
                        a(outputStream, allocate2);
                    }
                } else {
                    allocate2.position(i3 * i * i36);
                    allocate2.limit(i3 * i * i49);
                    a(outputStream, allocate2);
                    i14 = i37 + (i49 - i36);
                    z5 = false;
                    i15 = i36;
                }
                i16 = (i66 - 1) / (i13 / i20);
                if (i16 > i34) {
                }
                while (i17 < i) {
                }
                int i742 = i66 - (i16 * (i13 / i20));
                while (i18 < i) {
                }
                int i752 = i42 + 1;
                if ((i42 & 7) != 7) {
                }
                i36 = i15;
                i37 = i14;
                i38 = i46;
                z6 = z5;
                i35 = i48;
                i39 = i49;
                i40 = i742;
                i42 = i752;
            }
        }
    }

    public double a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, double d, int i4, boolean z, int i5) throws IOException {
        ByteBuffer byteBuffer;
        double[] dArr = {0.0d};
        int i6 = 0;
        dTz();
        ByteBuffer byteBuffer2 = null;
        if (z) {
            byteBuffer2 = ByteBuffer.allocate(8);
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        int i7 = 0;
        while (i7 < i4 * i) {
            double d2 = 0.0d;
            switch (i2) {
                case 1:
                    allocate.position(0);
                    allocate.limit(1);
                    byte[] bArr = new byte[allocate.limit()];
                    inputStream.read(bArr);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.position(wrap.limit());
                    wrap.flip();
                    d2 = 0.007874015748031496d * (wrap.get(0) - 128);
                    byteBuffer = wrap;
                    break;
                case 2:
                    allocate.position(0);
                    allocate.limit(2);
                    byte[] bArr2 = new byte[allocate.limit()];
                    inputStream.read(bArr2);
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
                    wrap2.position(wrap2.limit());
                    wrap2.flip();
                    d2 = wrap2.order(this.nPm).asShortBuffer().get(0) * 3.051850947599719E-5d;
                    byteBuffer = wrap2;
                    break;
                case 3:
                    allocate.position(0);
                    allocate.limit(3);
                    byte[] bArr3 = new byte[allocate.limit()];
                    inputStream.read(bArr3);
                    ByteBuffer wrap3 = ByteBuffer.wrap(bArr3);
                    wrap3.position(wrap3.limit());
                    wrap3.flip();
                    d2 = 1.1920930376163766E-7d * (((wrap3.get(0) & 255) << 0) | ((wrap3.get(1) & 255) << 8) | ((wrap3.get(2) & 255) << 16));
                    byteBuffer = wrap3;
                    break;
                case 4:
                    allocate.position(0);
                    allocate.limit(4);
                    byte[] bArr4 = new byte[allocate.limit()];
                    inputStream.read(bArr4);
                    ByteBuffer wrap4 = ByteBuffer.wrap(bArr4);
                    wrap4.position(wrap4.limit());
                    wrap4.flip();
                    d2 = wrap4.order(this.nPm).asIntBuffer().get(0) * 4.656612875245797E-10d;
                    byteBuffer = wrap4;
                    break;
                default:
                    byteBuffer = allocate;
                    break;
            }
            if (inputStream.available() != 0) {
                double d3 = d2 * d;
                if (!z) {
                    switch (i3) {
                        case 1:
                            double d4 = 127.0d * d3;
                            int a2 = i5 != 0 ? a(d4, dArr, i5, i6) : z(d4);
                            byteBuffer.position(0);
                            byteBuffer.limit(1);
                            byteBuffer.put(0, (byte) (a2 + 128));
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                        case 2:
                            double d5 = 32767.0d * d3;
                            int a3 = i5 != 0 ? a(d5, dArr, i5, i6) : z(d5);
                            byteBuffer.position(0);
                            byteBuffer.limit(2);
                            byteBuffer.asShortBuffer().put(0, (short) a3);
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                        case 3:
                            double d6 = 8388607.0d * d3;
                            int a4 = i5 != 0 ? a(d6, dArr, i5, i6) : z(d6);
                            byteBuffer.position(0);
                            byteBuffer.limit(3);
                            byteBuffer.put(0, (byte) (a4 & 255));
                            int i8 = a4 >> 8;
                            byteBuffer.put(1, (byte) (i8 & 255));
                            byteBuffer.put(2, (byte) ((i8 >> 8) & 255));
                            byteBuffer.flip();
                            a(outputStream, byteBuffer);
                            break;
                    }
                } else {
                    double d7 = d3 > 0.0d ? d3 : -d3;
                    if (dArr[0] >= d7) {
                        d7 = dArr[0];
                    }
                    dArr[0] = d7;
                    byteBuffer2.position(0);
                    byteBuffer2.putDouble(d3);
                    byteBuffer2.flip();
                    a(outputStream, byteBuffer2);
                }
                int i9 = i6 + 1;
                int i10 = i9 == i ? 0 : i9;
                int i11 = i7 + 1;
                if ((262143 & i11) == 0) {
                    C(i11 / (i4 * i));
                }
                allocate = byteBuffer;
                i7 = i11;
                i6 = i10;
            } else {
                C(1.0d);
                return dArr[0];
            }
        }
        C(1.0d);
        return dArr[0];
    }

    public j() {
        this.nPm = ByteOrder.LITTLE_ENDIAN;
        this.nPn = new k();
        this.nPo = 150.0d;
        this.nPp = 200.0d;
        this.nPq = 1;
        this.nPC = false;
    }

    public j(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3, int i4, int i5, int i6, double d, int i7, boolean z) throws Exception {
        int i8;
        int i9;
        this.nPm = ByteOrder.LITTLE_ENDIAN;
        this.nPn = new k();
        this.nPo = 150.0d;
        this.nPp = 200.0d;
        this.nPq = 1;
        this.nPC = false;
        double[] dArr = {0.0d};
        if (i7 < 0 || i7 > 4) {
            throw new IllegalArgumentException("unrecognized dither type : " + i7);
        }
        this.nPC = z;
        if (!this.nPC) {
            System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
        }
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
        }
        if (i4 == -1) {
            i8 = i3 != 1 ? i3 : 2;
            if (i8 == 4) {
                i8 = 3;
            }
        } else {
            i8 = i4;
        }
        int i10 = i2 == -1 ? i : i2;
        if (i7 != -1) {
            i9 = i7;
        } else if (i8 < i3) {
            if (i8 == 1) {
                i9 = 4;
            } else {
                i9 = 3;
            }
        } else {
            i9 = 1;
        }
        if (!this.nPC) {
            String[] strArr = {"none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)"};
            String[] strArr2 = {"rectangular", "triangular", "gaussian"};
            System.err.printf("frequency : %d -> %d\n", Integer.valueOf(i), Integer.valueOf(i10));
            System.err.printf("attenuation : %gdB\n", Double.valueOf(d));
            System.err.printf("bits per sample : %d -> %d\n", Integer.valueOf(i3 * 8), Integer.valueOf(i8 * 8));
            System.err.printf("nchannels : %d\n", Integer.valueOf(i5));
            System.err.printf("length : %d bytes, %g secs\n", Integer.valueOf(i6), Double.valueOf(((i6 / i3) / i5) / i));
            if (i9 == 0) {
                System.err.printf("dither type : none\n", new Object[0]);
            } else {
                System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", strArr[i9], strArr2[0], Double.valueOf(0.18d));
            }
            System.err.printf("\n", new Object[0]);
        }
        if (i9 != 0) {
            int i11 = 0;
            int i12 = 0;
            if (i8 == 1) {
                i11 = -128;
                i12 = ThunderNetStateService.NetState.SYSNET_UNKNOWN;
            }
            if (i8 == 2) {
                i11 = -32768;
                i12 = 32767;
            }
            if (i8 == 3) {
                i11 = -8388608;
                i12 = 8388607;
            }
            if (i8 == 4) {
                i11 = Integer.MIN_VALUE;
                i12 = Integer.MAX_VALUE;
            }
            a(i10, i5, i11, i12, i9, 0, 0.18d);
        }
        if (i < i10) {
            dArr[0] = a(inputStream, outputStream, i5, i3, i8, i, i10, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        } else if (i > i10) {
            dArr[0] = b(inputStream, outputStream, i5, i3, i8, i, i10, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        } else {
            dArr[0] = a(inputStream, outputStream, i5, i3, i8, Math.pow(10.0d, (-d) / 20.0d), (i6 / i3) / i5, false, i9);
        }
        if (!this.nPC) {
            System.err.printf("\n", new Object[0]);
        }
        if (i9 != 0) {
            KH(i5);
        }
        if (dArr[0] > 1.0d && !this.nPC) {
            System.err.printf("clipping detected : %gdB\n", Double.valueOf(20.0d * Math.log10(dArr[0])));
        }
    }

    protected byte[] m(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.limit() - byteBuffer.position()];
        byteBuffer.get(bArr, 0, bArr.length);
        return bArr;
    }

    protected void a(OutputStream outputStream, ByteBuffer byteBuffer) {
        try {
            outputStream.write(m(byteBuffer));
        } catch (IOException e) {
        }
    }
}
