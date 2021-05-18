package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class DecoderJNI implements INoProGuard {

    /* loaded from: classes5.dex */
    public static class Wrapper implements INoProGuard {
        public final long[] context;
        public final ByteBuffer inputBuffer;
        public a lastStatus = a.NEEDS_MORE_INPUT;
        public boolean fresh = true;

        public Wrapper(int i2) throws IOException {
            this.context = r0;
            long[] jArr = {0, i2};
            this.inputBuffer = WebSettingsGlobalBlink.kernelBrotliCreate(jArr);
            if (this.context[0] == 0) {
                throw new IOException("failed to initialize native brotli decoder");
            }
        }

        private void parseStatus() {
            long j = this.context[1];
            this.lastStatus = j == 1 ? a.DONE : j == 2 ? a.NEEDS_MORE_INPUT : j == 3 ? a.NEEDS_MORE_OUTPUT : j == 4 ? a.OK : a.ERROR;
        }

        public void destroy() throws IOException {
            long[] jArr = this.context;
            if (jArr[0] == 0) {
                throw new IOException("brotli decoder is already destroyed");
            }
            WebSettingsGlobalBlink.kernelBrotliDestroy(jArr);
            this.context[0] = 0;
        }

        public void finalize() throws Throwable {
            if (this.context[0] != 0) {
                destroy();
            }
            super.finalize();
        }

        public ByteBuffer getInputBuffer() {
            return this.inputBuffer;
        }

        public a getStatus() {
            return this.lastStatus;
        }

        public boolean hasOutput() {
            return this.context[2] != 0;
        }

        public ByteBuffer pull() throws IOException {
            if (this.context[0] != 0) {
                if (this.lastStatus == a.NEEDS_MORE_OUTPUT || hasOutput()) {
                    this.fresh = false;
                    ByteBuffer kernelBrotliPull = WebSettingsGlobalBlink.kernelBrotliPull(this.context);
                    parseStatus();
                    return kernelBrotliPull;
                }
                throw new IOException("pulling output from decoder in " + this.lastStatus + " state");
            }
            throw new IOException("brotli decoder is already destroyed");
        }

        public void push(int i2) throws IOException {
            if (i2 < 0) {
                throw new IOException("negative block length");
            }
            if (this.context[0] == 0) {
                throw new IOException("brotli decoder is already destroyed");
            }
            a aVar = this.lastStatus;
            if (aVar != a.NEEDS_MORE_INPUT && aVar != a.OK) {
                throw new IOException("pushing input to decoder in " + this.lastStatus + " state");
            } else if (this.lastStatus == a.OK && i2 != 0) {
                throw new IOException("pushing input to decoder in OK state");
            } else {
                this.fresh = false;
                WebSettingsGlobalBlink.kernelBrotliPush(this.context, i2);
                parseStatus();
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum a {
        ERROR,
        DONE,
        NEEDS_MORE_INPUT,
        NEEDS_MORE_OUTPUT,
        OK
    }
}
